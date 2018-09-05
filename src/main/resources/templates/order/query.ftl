<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
    <meta name="author" content="Łukasz Holeczek">
    <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
    <title>CarBlock</title>
    <#--<link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon">-->
    <!-- Icons-->
    <link href="/node_modules/@coreui/icons/css/coreui-icons.min.css" rel="stylesheet">
    <link href="/node_modules/flag-icon-css/css/flag-icon.min.css" rel="stylesheet">
    <link href="/node_modules/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/node_modules/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">
    <!-- Main styles for this application-->
    <link href="/css/style.css" rel="stylesheet">
    <link href="/vendors/pace-progress/css/pace.min.css" rel="stylesheet">
      <#--<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">-->
      <#--<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>-->
  </head>
  <body class="app header-fixed sidebar-fixed aside-menu-fixed sidebar-lg-show">
    <#include "../public/header.ftl"/>
    <div class="app-body">
      <#include "../public/left.ftl"/>
      <main class="main">
        <!-- Breadcrumb-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Home</li>
          <li class="breadcrumb-item active">Query & Purchase</li>
        </ol>
        <div class="container-fluid">
          <div class="animated fadeIn">
            <div class="row">
              <div class="col-lg-12">
              
                <div class="card">
                  <div class="card-header">
                    <strong>Query</strong>
                  </div>
                  <div class="card-body">
                    <div class="row">
                      <div class="form-group col-sm-3">
                        <select class="form-control" id="ccmonth">
                          <option>Data Type</option>
                          <option>Battery Voltage</option>
                        </select>
                      </div>
                      <div class="form-group col-sm-2">
                        <select class="form-control"  id="ccyear">
                          <option>- Country -</option>
                          <#list countryList as c>
                          <option value="${c.countryId}">${c.nameEnglish}</option>
                          </#list>
                            </optgroup>
                        </select>
                      </div>
                      <div class="form-group col-sm-2">
                        <select class="form-control" id="ccyear">
                          <option>Date</option>
                          <option>Last Mouth</option>
                        </select>
                      </div>
                      <div class="form-group col-sm-2">
                          <button class="btn btn-block btn-primary" type="submit">
	                         Submit</button>
                      </div>
                    </div>
                    <!-- /.row-->
                  </div>
                </div>
              
              <form action="/query/purchaseconfirm">
                <div class="card">
                  <div class="card-header">
                    <i class="fa fa-align-justify"></i> Result Summary</div>
                  <div class="card-body">
                    <div class="row">
                      <div class="col-sm-2">
                        User: ${usercount}
                      </div>
                      <div class="col-sm-2">
                        Data Block: ${blockcount}
                      </div>
                      <div class="col-sm-2">
                          <button class="btn btn-block btn-primary" type="submit">
	                         Purchase</button>
                      </div>
                    </div>
                  </div>
                </div>
              </form>
                <div class="card">
                  <div class="card-header">
                    <i class="fa fa-align-justify"></i> Simple Users</div>
                  <div class="card-body">
                    <table class="table table-responsive-sm">
                      <thead>
                        <tr>
                          <th>User ID</th>
                          <th>Country</th>
                          <th>Vehicle</th>
                          <th>Data </th>
                        </tr>
                      </thead>
                      <tbody>
                      <#list metaMain as mm>
                      <#if mm_index<10 >
                        <tr>
                          <td>${mm.userId!}</td>
                          <td>${mm.country!}</td>
                          <td>${mm.vehicleType!}</td>
                          <td>${mm.validTime!}</td>
                        </tr>
                      </#if>
                      </#list>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              <!-- /.col-->
            </div>
            <!-- /.row-->
          </div>
        </div>
      </main>
    </div>
    <footer class="app-footer">
      <div>
        <a href="https://cablock.io">CarBlock</a>
        <span>&copy; 2018</span>
      </div>
    </footer>
    <!-- CoreUI and necessary plugins-->
    <script src="/node_modules/jquery/dist/jquery.min.js"></script>
    <script src="/node_modules/popper.js/dist/umd/popper.min.js"></script>
    <script src="/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/node_modules/pace-progress/pace.min.js"></script>
    <script src="/node_modules/perfect-scrollbar/dist/perfect-scrollbar.min.js"></script>
    <script src="/node_modules/@coreui/coreui/dist/js/coreui.min.js"></script>
  </body>
</html>