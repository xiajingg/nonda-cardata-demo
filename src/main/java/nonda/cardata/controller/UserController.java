package nonda.cardata.controller;


import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import nonda.cardata.model.*;
import nonda.cardata.service.ICarDataMongoService;
import nonda.cardata.service.ITireDatamService;
import nonda.cardata.service.ITireService;
import nonda.cardata.service.impl.MongoUserServiceImpl;
import nonda.cardata.service.impl.UserServiceImpl;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xiajing on 2018/5/15.
 */

//给整个类指定一个url
@RequestMapping("/user/")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private MongoUserServiceImpl mongoUserService;

    @Autowired
    private ICarDataMongoService iCarDataMongoService;

    @Autowired
    private ITireService iTireService;
    @Autowired
    private ITireDatamService iTireDatamService;

    @GetMapping(value = "fd")
    public ModelAndView fd(){

        return new ModelAndView("/user/findAll");
    }

    @GetMapping(value = "de")
    public ModelAndView de(Map map){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
        map.put("year", sdf.format(new Date()));
        return new ModelAndView("/user/insertDelivery");
    }

    @PostMapping(value = "upload")
    public Map upload(@RequestParam("file") MultipartFile file)throws Exception {
        Map map=new HashMap();
        POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        int trLength = sheet.getLastRowNum();
        HSSFRow row = sheet.getRow(0);
        int tdLength = row.getLastCellNum();
        map.put("data", "1");
        return map;
    }

    @GetMapping(value = "/usersss")
    public String findtest(){
        for (int i = 0; i < 10; i++) {
            Page<TireDataMongo> tireDataMongoAll=iCarDataMongoService.findOne(i,10);
            List<TireDataMongo> mongos=tireDataMongoAll.getContent();
            for (int j = 0; j < mongos.size(); j++) {
                Tire tire=new Tire();
                tire.setId(mongos.get(j).get_id());
                tire.setPUser(mongos.get(j).get_p_user());
                tire.setTime(mongos.get(j).getTime());
                tire.setPos(mongos.get(j).getPos());
                tire.setPVehicle(mongos.get(j).get_p_vehicle());
                tire.setUpdatedTime(mongos.get(j).get_created_at());
                tire.setCreatedTime(mongos.get(j).get_created_at());
                iTireService.save(tire);

                try {
                    JSONObject jsonObject = null;
                    try {
                        if (mongos.get(j).getData()!=null)
                        jsonObject = JSONObject.fromObject(mongos.get(j).getData());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (jsonObject!=null) {
                        Map<String, Object> map = jsonObject;
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            System.out.println(entry.getKey()+"="+entry.getValue());
                            TireDatam tireDatam = new TireDatam();
                            tireDatam.setId(UUIDHelper.getUUID32());
                            tireDatam.setTireId(tire.getId());
                            tireDatam.setTime_division(entry.getKey());
                            JSONObject jsonObject1 = JSONObject.fromObject(entry.getValue());
                            tireDatam.setTemperature(jsonObject1.get("t").toString());
                            tireDatam.setPressure(Double.parseDouble(jsonObject1.get("p").toString()));
                            tireDatam.setIsLeak(jsonObject1.get("leak").toString());
                            tireDatam.setIsLost(jsonObject1.get("lost").toString());
                            tireDatam.setLowBattery(jsonObject1.get("low_battery").toString());
                            iTireDatamService.save(tireDatam);

                            System.out.println("i:"+i+"j:"+j);
                        }
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        return "";
    }

    @GetMapping(value = "findAll")
    public List<User> findAll(){
        List<User> userList= userService.findAll();
        return userList;
    }

    @GetMapping(value = "findByUsername/{username}")
    public ModelAndView findByUsername(@PathVariable("username") String username, Map<String,Object> map){
        List<User> userList= userService.findByUsername(username);
//        map.put("user",userList.get(0));
//        System.out.println("1");
        return new ModelAndView("user/findByUsername",map);
    }

//    @GetMapping(value = "id/{id}")
//    public User getOne(@PathVariable("id") Integer id){
//        return userService.getOne(id);
//
//    }

    @GetMapping(value = "createUser,updateUser")
    public List<User> createUser(@RequestParam("username") String username,@RequestParam("id") Integer id){
        User user=new User();
//        user.setId(id);
        user.setUsername(username);
        userService.createUser(user);
        return findAll();
    }

    @GetMapping(value = "createUser2")
    public List<User> createUser2(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.err.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
//        user.setId(user.getId());
//        user.setUsername(user.getUsername());
//        user.setAge(user.getAge());
        userService.createUser(user);
        return findAll();
    }

//    @GetMapping(value = "deleteUser/{id}")
//    public void deleteUser(@PathVariable("id") Integer id){
//        userService.deleteUser(id);
//    }

//
//    @PostMapping(value = "addMongoUser")
//    public MongoUser addMongoUser(@Valid MongoUser mongoUser,@RequestParam("a") String a){
////        mongoUser.setId(mongoUser.getId());
////        mongoUser.setName(mongoUser.getName());
//        System.out.println(1+"\n"+1);
//        return mongoUserService.insert(mongoUser);
//
//    }


    @PostMapping(value = "addMongoUser")
    public MongoUser addMongoUser(){
        String a="{\"_id\":\"Rv1NFzNUpv2\",\"_p_user\":\"_User$Qd8JLITGAt\",\"time\":1525219200000,\"pos\":\"fr\",\"data\":{\"844\":{\"t\":34,\"p\":261.44155137450235,\"leak\":0,\"lost\":0,\"low_battery\":0},\"845\":{\"t\":35,\"p\":261.44155137450235,\"leak\":0,\"lost\":0,\"low_battery\":0},\"846\":{\"t\":35,\"p\":261.44155137450235,\"leak\":0,\"lost\":0,\"low_battery\":0}},\"_p_vehicle\":\"Vehicle$TpkGb465tY\",\"_updated_at\":{\"$date\":\"2018-05-02T14:07:11.941Z\"},\"_created_at\":{\"$date\":\"2018-05-02T14:07:11.941Z\"}}";
        JSONObject jsonObject=JSONObject.fromObject(a);
        MongoUser mongoUser=new MongoUser();
        mongoUser.set_id(jsonObject.getString("_id"));
//        mongoUser.set_p_user(jsonObject.getString("_p_user"));
//        mongoUser.setTime(jsonObject.getString("time"));
//        mongoUser.setPos(jsonObject.getString("pos"));
//        mongoUser.setData(jsonObject.getString("data"));
//        mongoUser.set_p_evechicle(jsonObject.getString("_p_vehicle"));
//        mongoUser.set_updated_at(jsonObject.getString("_updated_at"));
//        mongoUser.set_created_at(jsonObject.getString("_created_at"));
        return mongoUserService.insert(mongoUser);
    }

//    @GetMapping(value = "findMongoUserAll")
//    @Transactional
//    public List<MongoUser> findMongoUserAll(){
//        List<MongoUser> mongoUserList=mongoUserService.findAll();
//        List<User> user=new ArrayList<>();
//        if(mongoUserList.size()>50)
//        for (int i=0;i<5;i++){
//            MongoUser mongoUser = mongoUserList.get(i);
//            user.add(new User(mongoUser.get_id(), mongoUser.get_session_token(), mongoUser.get_hashed_password(), mongoUser.get_perishable_token(), mongoUser.get_created_at(), mongoUser.get_updated_at(), mongoUser.getUsername(), mongoUser.getEmailVerified(), mongoUser.getRegisterFrom(), mongoUser.getEmail(), mongoUser.getFirstName(), mongoUser.get_email_verify_token(), mongoUser.getConfig()));
//            try {
//                Thread.sleep(300);
//                System.out.println(i+1);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        userService.createUserList(user);
//        return mongoUserList;
//    }

    @GetMapping(value = "findByusername")
    public MongoUser findByusername(@RequestParam("username") String username){
       MongoUser mongoUser= mongoUserService.findByusername(username);
       JSONObject jsonObject=new JSONObject();

       return mongoUser;

    }

    @RequestMapping(value = "testDownload", method = RequestMethod.GET)
    public void testDownload(HttpServletResponse res) {
        File[] roots = File.listRoots();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date=format.format(new Date());
        String fileName = date+"workbook.xls";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();

            Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
            Sheet sheet1 = wb.createSheet("new 1111sheet");
            Sheet sheet2 = wb.createSheet("second sheet");

            // Note that sheet name is Excel must not exceed 31 characters
            // and must not contain any of the any of the following characters:
            // 0x0000
            // 0x0003
            // colon (:)
            // backslash (\)
            // asterisk (*)
            // question mark (?)
            // forward slash (/)
            // opening square bracket ([)
            // closing square bracket (])

            // You can use org.apache.poi.ss.util.WorkbookUtil#createSafeSheetName(String nameProposal)}
            // for a safe way to create valid names, this utility replaces invalid characters with a space (' ')
            String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]"); // returns " O'Brien's sales   "
            Sheet sheet3 = wb.createSheet(safeName);

            try (OutputStream fileOut = new FileOutputStream(roots[0].toString()+"carDataExcel/"+fileName)) {
                wb.write(fileOut);
                fileOut.flush();
                bis = new BufferedInputStream(new FileInputStream(new File(roots[0].toString()+"carDataExcel/"+fileName)));
                int i = bis.read(buff);
                while (i != -1) {
                    os.write(buff, 0, buff.length);
                    os.flush();
                    i = bis.read(buff);
                }



            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }

    @GetMapping("down")
    public String down(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/vnd.ms-excel");
        OutputStream out = response.getOutputStream();
        //报头用于提供一个推荐的文件名，并强制浏览器显示保存对话框
        //attachment表示以附件方式下载。如果要在页面中打开，则改为 inline
        response.setHeader("Content-Disposition", "attachment; filename=TestExcel1.xls ");
        //创建workbook工作薄
        Workbook workbook = new HSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet("用户信息");
        //创建第二个工作薄
//        Sheet sheet2 = workbook.createSheet();
        //为工作薄起名字
        workbook.setSheetName(1, "口袋里的小龙");
        //设置单元格样式
        HSSFCellStyle hssfCellStyle = (HSSFCellStyle) workbook.createCellStyle();
//        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中显示
//        hssfCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//纵向居中
        //创建行
        Row row = sheet.createRow(0);
        //创建单元格
        Cell cell = row.createCell(0);
        //设置第一行第一格的值
        cell.setCellValue("姓名");
        //设置单元格的文本居中显示
        cell.setCellStyle(hssfCellStyle);
        //创建单元格
        Cell cell1 = row.createCell(1);
        //设置第一行第一格的值
        cell1.setCellValue("性别");
        cell1.setCellStyle(hssfCellStyle);
        //创建单元格
        Cell cell2 = row.createCell(2);
        //设置第一行第一格的值
        cell2.setCellValue("年龄");
        cell2.setCellStyle(hssfCellStyle);
        //创建单元格
        Cell cell3 = row.createCell(3);
        //设置第一行第一格的值
        cell3.setCellValue("家庭住址");
        cell3.setCellStyle(hssfCellStyle);
        for (int i = 1; i <= 5; i++) {
            //创建行
            Row rows = sheet.createRow(i);
            //创建单元格
            Cell cells = rows.createCell(0);
            //设置第一行第一格的值
            cells.setCellValue("张三"+i);
            //创建单元格
            Cell cell1s = rows.createCell(1);
            //设置第一行第一格的值
            cell1s.setCellValue("男");
            //创建单元格
            Cell cell2s = rows.createCell(2);
            //设置第一行第一格的值
            cell2s.setCellValue(18+i);
            //创建单元格
            Cell cell3s = rows.createCell(3);
            //设置第一行第一格的值
            cell3s.setCellValue("家庭住址"+i);
        }
        workbook.write(out);
        System.out.println("数据写入成功！");
        out.flush();
        out.close();
        return "";
    }


    @GetMapping(value = "test")
    public void test(@RequestParam(value = "id",defaultValue = "")List<String> id){
        for (String id1:id){
            System.out.println("页面提交"+id1);
        }

    }

}
