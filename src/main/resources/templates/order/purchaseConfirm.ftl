<!DOCTYPE html>
<html lang="en">
  <head>
    <#--<base href="./../../">-->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
    <meta name="author" content="Łukasz Holeczek">
    <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
    <title>CoreUI Free Bootstrap Admin Template</title>
    <!-- Icons-->
    <link href="/node_modules/@coreui/icons/css/coreui-icons.min.css" rel="stylesheet">
    <link href="/node_modules/flag-icon-css/css/flag-icon.min.css" rel="stylesheet">
    <link href="/node_modules/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/node_modules/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">
    <!-- Main styles for this application-->
    <link href="/css/style.css" rel="stylesheet">
    <link href="/vendors/pace-progress/css/pace.min.css" rel="stylesheet">
  </head>
  <body class="app header-fixed sidebar-fixed aside-menu-fixed sidebar-lg-show">
    <#include "../public/header.ftl"/>
    <div class="app-body">
      <#include "../public/left.ftl"/>
      <main class="main">
        <!-- Breadcrumb-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Home</li>
          <li class="breadcrumb-item ">Query & Purchase</li>
          <li class="breadcrumb-item active">Purchase Confirm</li>
        </ol>
        <div class="container-fluid">
          <div class="animated fadeIn">
            <div class="row">
              <div class="col-lg-12">
            
              
                <div class="card">
                  <div class="card-header">
                    <strong>Purchase Confirm</strong></div>
                    <form class="form-horizontal" action="/query/purchasesuccess" method="post">
                  <div class="card-body">
                      <div class="form-group row">
                        <div class="col-md-2">Data Type</div>
                        <div class="col-md-10">
                          Battery Voltage
                        </div>
                      </div>
                      <div class="form-group row">
                        <div class="col-md-2">Users</div>
                        <div class="col-md-10">
                          ${usercount}
                        </div>
                      </div>
                      <div class="form-group row">
                        <div class="col-md-2">Data Blocks</div>
                        <div class="col-md-10">
                          ${blockcount}
                        </div>
                      </div>
                      <div class="form-group row">
                        <div class="col-md-2">Price</div>
                        <div class="col-md-10">
                        ${blockcount*1000}CAR  (Unit Price : 1,000 CAR / Data Block )
                        </div>
                      </div>
                      <div class="form-group row">
                        <div class="col-md-2">Gas</div>
                        <div class="col-md-10">
                          ${blockcount*100} CAR (Unit Gas : 100 CAR / Transfer)
                        </div>
                      </div>
                      <div class="form-group row">
                        <div class="col-md-2">Total Price</div>
                        <div class="col-md-10">
                        ${(blockcount*1000)+(blockcount*100)} CAR
                        </div>
                      </div>
                      <div class="form-group row">
                        <div class="col-md-2">Expiration Time</div>
                        <div class="col-md-10">
                          T + 7
                        </div>
                      </div>
                      <div class="form-group row">
                        <label class="col-md-2 col-form-label">Purpose</label>
                        <div class="col-md-10">
                          <textarea class="form-control" id="textarea-input" name="textarea-input" rows="9" placeholder="Please enter the purpose. Users will see these content, and make the decision."></textarea>
                        </div>
                      </div>

                  </div>
                  <div class="card-footer">
                    <button class="btn btn-primary" type="submit">
                      <i class="fa fa-dot-circle-o"></i> Confirm</button>
                  </div>
                    </form>
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