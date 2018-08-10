package nonda.cardata.controller;

import com.csvreader.CsvReader;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiajing on 2018/4/16.
 */
//@RestController = @Controller + @ResponseBody
@RestController
//给整个类指定一个url
@RequestMapping("/hello")
public class hellocontroller {
//
//    @Autowired
//    private nonda.cardata.model.User User;
//    /**
//     *
//     * @return
//     * value = {"/hello","/hi"}两个都能访问
//     */
//    @RequestMapping(value = "/hello1/{id}/{id2}", method = RequestMethod.GET)
//    public String say(@PathVariable("id") Integer id,@RequestParam(value = "id2" ,required = false , defaultValue = "0") Integer id2){
//        System.out.println("hello");
//        System.out.println("1::"+id);
//        System.out.println("2::"+id2);
//        return "";
//    }


    @PostMapping(value = "insertreports")
    public Map insertreports(@RequestParam("file") MultipartFile file) throws Exception {
        Map map=new HashMap();
        InputStream is = file.getInputStream();
        Date date = new Date();
        String uri = date + "reports.csv";
        FileOutputStream output = new FileOutputStream(uri);
        IOUtils.copy(is, output);
        output.close();
        File file1 = new File(uri);

        // 创建CSV读对象
        CsvReader csvReader = new CsvReader(file1.toString());

        int j = 1;
        //US报表有22列, CA报表只有21列,  US多了一列, 这个flag判断是否多一列, 再根据情况取报表的值
        //flase就取22列  true就取21列    1ca  2uk  3jp 4美国
        int flag=0;
        while (csvReader.readRecord()) {
            map.put("data", new String(csvReader.get(0).getBytes("utf8"),"Shift_JIS"));

            // 读一整行
            if (j==7&&csvReader.get(20).equals("total")){
                flag=2;
                j++;
                continue;
            }else if(j==8 && csvReader.get(22).equals("total")){
                flag=4;
                j++;
                continue;
            }else if (j==8 && csvReader.get(21).equals("total")){
                flag=1;
                j++;
                continue;
            }else if(j==7 && csvReader.get(21).equals("合計")){
                flag=3;
                j++;
                continue;
            }

//            if (flag==1){
//                AmazonReports amazonReports = new AmazonReports();
//                amazonReports.setId(UUIDHelper.getUUID32());
//                // 读这行的某一列
////                    System.out.println(csvReader.get(0));
//                Date datetime = null;
//                if (csvReader.get(0).indexOf("GMT") != -1) {
//                    datetime = new Date(StringUtils.substringBeforeLast(csvReader.get(0), "GMT"));
//                } else if (csvReader.get(0).indexOf("PDT") != -1) {
//                    try {
//                        datetime = new Date(StringUtils.substringBeforeLast(csvReader.get(0), "PDT"));
//                    } catch (Exception e) {
//                        datetime = new Date(StringUtils.replace(StringUtils.substringBeforeLast(csvReader.get(0), "PDT"), "-", "/"));
//                    }
//                } else if (csvReader.get(0).indexOf("GMT") != -1) {
//                    datetime = new Date(StringUtils.substringBeforeLast(csvReader.get(0), "GMT"));
//                } else if (csvReader.get(0).indexOf("PST") != -1) {
//                    try {
//                        datetime = new Date(StringUtils.substringBeforeLast(csvReader.get(0), "PST"));
//                    } catch (Exception e) {
//                        //有时候时间字段 是 yyyy-MM-dd  new date不识别 - 要替换成 /
//                        datetime = new Date(StringUtils.replace(StringUtils.substringBeforeLast(csvReader.get(0), "PST"), "-", "/"));
//                    }
//                } else {
//                }
//                amazonReports.setDatetime(datetime);
//                System.out.println(csvReader.get(1));
//                amazonReports.setSettlementID(csvReader.get(1));
//                System.out.println(csvReader.get(2));
//                amazonReports.setOrderType(csvReader.get(2));
//                System.out.println(csvReader.get(3));
//                amazonReports.setOrderID(csvReader.get(3));
//                System.out.println(csvReader.get(4));
//                amazonReports.setSku(csvReader.get(4));
//                System.out.println(csvReader.get(5));
//                amazonReports.setDescription(csvReader.get(5));
//                System.out.println(csvReader.get(6));
//                try {
//                    amazonReports.setQuantity(new DecimalFormat().parse(csvReader.get(6)).intValue());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                System.out.println(csvReader.get(7));
//                amazonReports.setMarketplace(csvReader.get(7));
//                System.out.println(csvReader.get(8));
//                amazonReports.setFulfillment(csvReader.get(8));
//                System.out.println(csvReader.get(9));
//                amazonReports.setOrderCity(csvReader.get(9));
//                System.out.println(csvReader.get(10));
//                amazonReports.setOrderState(csvReader.get(10));
//                System.out.println(csvReader.get(11));
//                amazonReports.setOrderPostal(csvReader.get(11));
//                System.out.println(csvReader.get(12));
//                amazonReports.setProductSales(new DecimalFormat().parse(csvReader.get(12)).doubleValue());
//                System.out.println(csvReader.get(13));
//                amazonReports.setShippingCredits(new DecimalFormat().parse(csvReader.get(13)).doubleValue());
//                System.out.println(csvReader.get(14));
//                amazonReports.setGiftWrapCredits(new DecimalFormat().parse(csvReader.get(14)).doubleValue());
//                System.out.println(csvReader.get(15));
//                amazonReports.setSalesTaxCollected(new DecimalFormat().parse(csvReader.get(15)).doubleValue());
//                System.out.println(csvReader.get(16));
//                amazonReports.setMarketplaceFacilitatorTax(new DecimalFormat().parse(csvReader.get(16)).doubleValue());
//                System.out.println(csvReader.get(18));
//                amazonReports.setSellingFees(new DecimalFormat().parse(csvReader.get(17)).doubleValue());
//                System.out.println(csvReader.get(19));
//                amazonReports.setFbaFees(new DecimalFormat().parse(csvReader.get(18)).doubleValue());
//                System.out.println(csvReader.get(20));
//                amazonReports.setOtherTransactionFees(new DecimalFormat().parse(csvReader.get(19)).doubleValue());
//                System.out.println(csvReader.get(21));
//                amazonReports.setOther(new DecimalFormat().parse(csvReader.get(20)).doubleValue());
//                System.out.println(csvReader.get(22));
//                amazonReports.setTotal(new DecimalFormat().parse(csvReader.get(21)).doubleValue());
//                iAmazonReportsService.insert(amazonReports);
//            }else if(flag==2){
//                AmazonReports amazonReports = new AmazonReports();
//                amazonReports.setId(UUIDHelper.getUUID32());
//                // 读这行的某一列
////                    System.out.println(csvReader.get(0));
//                Date datetime = null;
//                if (csvReader.get(0).indexOf("GMT") != -1) {
//                    datetime = new Date(StringUtils.substringBeforeLast(csvReader.get(0), "GMT"));
//                } else if (csvReader.get(0).indexOf("PDT") != -1) {
//                    try {
//                        datetime = new Date(StringUtils.substringBeforeLast(csvReader.get(0), "PDT"));
//                    } catch (Exception e) {
//                        datetime = new Date(StringUtils.replace(StringUtils.substringBeforeLast(csvReader.get(0), "PDT"), "-", "/"));
//                    }
//                } else if (csvReader.get(0).indexOf("GMT") != -1) {
//                    datetime = new Date(StringUtils.substringBeforeLast(csvReader.get(0), "GMT"));
//                } else if (csvReader.get(0).indexOf("PST") != -1) {
//                    try {
//                        datetime = new Date(StringUtils.substringBeforeLast(csvReader.get(0), "PST"));
//                    } catch (Exception e) {
//                        //有时候时间字段 是 yyyy-MM-dd  new date不识别 - 要替换成 /
//                        datetime = new Date(StringUtils.replace(StringUtils.substringBeforeLast(csvReader.get(0), "PST"), "-", "/"));
//                    }
//                } else {
//                }
//                amazonReports.setDatetime(datetime);
//                System.out.println(csvReader.get(1));
//                amazonReports.setSettlementID(csvReader.get(1));
//                System.out.println(csvReader.get(2));
//                amazonReports.setOrderType(csvReader.get(2));
//                System.out.println(csvReader.get(3));
//                amazonReports.setOrderID(csvReader.get(3));
//                System.out.println(csvReader.get(4));
//                amazonReports.setSku(csvReader.get(4));
//                System.out.println(csvReader.get(5));
//                amazonReports.setDescription(csvReader.get(5));
//                System.out.println(csvReader.get(6));
//                try {
//                    amazonReports.setQuantity(new DecimalFormat().parse(csvReader.get(6)).intValue());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                System.out.println(csvReader.get(7));
//                amazonReports.setMarketplace(csvReader.get(7));
//                System.out.println(csvReader.get(8));
//                amazonReports.setFulfillment(csvReader.get(8));
//                System.out.println(csvReader.get(9));
//                amazonReports.setOrderCity(csvReader.get(9));
//                System.out.println(csvReader.get(10));
//                amazonReports.setOrderState(csvReader.get(10));
//                System.out.println(csvReader.get(11));
//                amazonReports.setOrderPostal(csvReader.get(11));
//                System.out.println(csvReader.get(12));
//                amazonReports.setProductSales(new DecimalFormat().parse(csvReader.get(12)).doubleValue());
//                System.out.println(csvReader.get(13));
//                amazonReports.setShippingCredits(new DecimalFormat().parse(csvReader.get(13)).doubleValue());
//                System.out.println(csvReader.get(14));
//                amazonReports.setGiftWrapCredits(new DecimalFormat().parse(csvReader.get(14)).doubleValue());
//                System.out.println(csvReader.get(15));
//                amazonReports.setSalesTaxCollected(new DecimalFormat().parse(csvReader.get(15)).doubleValue());
//                System.out.println(csvReader.get(16));
//                amazonReports.setSellingFees(new DecimalFormat().parse(csvReader.get(16)).doubleValue());
//                System.out.println(csvReader.get(17));
//                amazonReports.setFbaFees(new DecimalFormat().parse(csvReader.get(17)).doubleValue());
//                System.out.println(csvReader.get(18));
//                amazonReports.setOtherTransactionFees(new DecimalFormat().parse(csvReader.get(18)).doubleValue());
//                System.out.println(csvReader.get(19));
//                amazonReports.setOther(new DecimalFormat().parse(csvReader.get(19)).doubleValue());
//                System.out.println(csvReader.get(20));
//                amazonReports.setTotal(new DecimalFormat().parse(csvReader.get(20)).doubleValue());
//                iAmazonReportsService.insert(amazonReports);
//
//            }else if(flag==3){
//
//            }else if (flag==4) {
//                AmazonReports amazonReports = new AmazonReports();
//                amazonReports.setId(UUIDHelper.getUUID32());
//                // 读这行的某一列
////                    System.out.println(csvReader.get(0));
//                Date datetime = null;
//                if (csvReader.get(0).indexOf("GMT") != -1) {
//                    datetime = new Date(StringUtils.substringBeforeLast(csvReader.get(0), "GMT"));
//                } else if (csvReader.get(0).indexOf("PDT") != -1) {
//                    datetime = new Date(StringUtils.substringBeforeLast(csvReader.get(0), "PDT"));
//                } else if (csvReader.get(0).indexOf("GMT") != -1) {
//                    datetime = new Date(StringUtils.substringBeforeLast(csvReader.get(0), "GMT"));
//                } else if (csvReader.get(0).indexOf("PST") != -1) {
//                    try {
//                        datetime = new Date(StringUtils.substringBeforeLast(csvReader.get(0), "PST"));
//                    } catch (Exception e) {
//                        //有时候时间字段 是 yyyy-MM-dd  new date不识别 - 要替换成 /
//                        datetime = new Date(StringUtils.replace(StringUtils.substringBeforeLast(csvReader.get(0), "PST"), "-", "/"));
//                    }
//                } else {
//                }
//                amazonReports.setDatetime(datetime);
//                System.out.println(csvReader.get(1));
//                amazonReports.setSettlementID(csvReader.get(1));
//                System.out.println(csvReader.get(2));
//                amazonReports.setOrderType(csvReader.get(2));
//                System.out.println(csvReader.get(3));
//                amazonReports.setOrderID(csvReader.get(3));
//                System.out.println(csvReader.get(4));
//                amazonReports.setSku(csvReader.get(4));
//                System.out.println(csvReader.get(5));
//                amazonReports.setDescription(csvReader.get(5));
//                System.out.println(csvReader.get(6));
//                try {
//                    amazonReports.setQuantity(new DecimalFormat().parse(csvReader.get(6)).intValue());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                System.out.println(csvReader.get(7));
//                amazonReports.setMarketplace(csvReader.get(7));
//                System.out.println(csvReader.get(8));
//                amazonReports.setFulfillment(csvReader.get(8));
//                System.out.println(csvReader.get(9));
//                amazonReports.setOrderCity(csvReader.get(9));
//                System.out.println(csvReader.get(10));
//                amazonReports.setOrderState(csvReader.get(10));
//                System.out.println(csvReader.get(11));
//                amazonReports.setOrderPostal(csvReader.get(11));
//                System.out.println(csvReader.get(12));
//                amazonReports.setProductSales(new DecimalFormat().parse(csvReader.get(12)).doubleValue());
//                System.out.println(csvReader.get(13));
//                amazonReports.setShippingCredits(new DecimalFormat().parse(csvReader.get(13)).doubleValue());
//                System.out.println(csvReader.get(14));
//                amazonReports.setGiftWrapCredits(new DecimalFormat().parse(csvReader.get(14)).doubleValue());
//                System.out.println(csvReader.get(15));
//                amazonReports.setSalesTaxCollected(new DecimalFormat().parse(csvReader.get(15)).doubleValue());
//                System.out.println(csvReader.get(16));
//                amazonReports.setMarketplaceFacilitatorTax(new DecimalFormat().parse(csvReader.get(16)).doubleValue());
//                System.out.println(csvReader.get(17));
//                amazonReports.setMarketplaceFacilitatorTax(new DecimalFormat().parse(csvReader.get(17)).doubleValue());
//                System.out.println(csvReader.get(18));
//                amazonReports.setSellingFees(new DecimalFormat().parse(csvReader.get(18)).doubleValue());
//                System.out.println(csvReader.get(19));
//                amazonReports.setFbaFees(new DecimalFormat().parse(csvReader.get(19)).doubleValue());
//                System.out.println(csvReader.get(20));
//                amazonReports.setOtherTransactionFees(new DecimalFormat().parse(csvReader.get(20)).doubleValue());
//                System.out.println(csvReader.get(21));
//                amazonReports.setOther(new DecimalFormat().parse(csvReader.get(21)).doubleValue());
//                System.out.println(csvReader.get(22));
//                amazonReports.setTotal(new DecimalFormat().parse(csvReader.get(22)).doubleValue());
//                iAmazonReportsService.insert(amazonReports);


//            }

            j++;
            return map;
        }
        return map;
    }
}
