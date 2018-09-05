<!DOCTYPE html>
<html lang="en">
  <head>
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
          <li class="breadcrumb-item ">Orders</li>
          <li class="breadcrumb-item active">Download Data</li>
        </ol>
        <div class="container-fluid">
          <div class="animated fadeIn">
            <div class="row">
              <div class="col-lg-12">
            
              <form action="/downloadrequestsuccess">
                <div class="card">
                  <div class="card-header">
                    <strong>Download Data</strong></div>
                  <div class="card-body">
                    <form class="form-horizontal" action="" method="post">
                      <p>
                        Please provide your private key, download the raw data.
                      </p>
                      <div class="form-group row">
                        <label class="col-md-2 col-form-label">Your Private Key</label>
                        <div class="col-md-10">
                          <input class="form-control" id="text-input" type="text" name="text-input" placeholder="Your Private Key">
                        </div>
                      </div>
                    </form>
                  </div>
                  <div class="card-footer">
                    <button class="btn btn-primary" type="submit">
                      Download</button>
                  </div>
                </div>
              </form>

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
    <script src="node_modules/jquery/dist/jquery.min.js"></script>
    <script src="node_modules/popper.js/dist/umd/popper.min.js"></script>
    <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="node_modules/pace-progress/pace.min.js"></script>
    <script src="node_modules/perfect-scrollbar/dist/perfect-scrollbar.min.js"></script>
    <script src="node_modules/@coreui/coreui/dist/js/coreui.min.js"></script>
  </body>
</html>