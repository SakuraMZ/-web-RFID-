<%@ page language="java" import="java.util.*" import="Servlet.*" pageEncoding="UTF-8"%> <%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Accounts - Product Admin Template</title>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Roboto:400,700"
    />
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link rel="stylesheet" href="css/fontawesome.min.css" />
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="css/templatemo-style.css">
    
  </head>

  <body id="reportsPage">
  <%
    Users stu = (Users) session.getAttribute("User");
  %>
    <div class="" id="home">
      <jsp:include page="Header.jsp"></jsp:include>
      <div class="container mt-5">
        <div class="row tm-content-row">
          <div class="col-12 tm-block-col">
            <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
              <h2 class="tm-block-title">List of Accounts</h2>
              <p class="text-white">Accounts</p>
              <select class="custom-select">
                <option value="0">Select account</option>
                <option value="1">Admin</option>
                <option value="2">Editor</option>
                <option value="3">Merchant</option>
                <option value="4">Customer</option>
              </select>
            </div>
          </div>
        </div>
        <!-- row -->
        <div class="row tm-content-row">
          <div class="tm-block-col tm-col-avatar">
            <div class="tm-bg-primary-dark tm-block tm-block-avatar">
              <h2 class="tm-block-title">Change Avatar</h2>
              <div class="tm-avatar-container">
                <img
                  src="img/avatar.png"
                  alt="Avatar"
                  class="tm-avatar img-fluid mb-4"
                />
                <a href="#" class="tm-avatar-delete-link">
                  <i class="far fa-trash-alt tm-product-delete-icon"></i>
                </a>
              </div>
              <button class="btn btn-primary btn-block text-uppercase">
                Upload New Photo
              </button>
            </div>
          </div>
          <div class="tm-block-col tm-col-account-settings">
            <div class="tm-bg-primary-dark tm-block tm-block-settings">
              <h2 class="tm-block-title">Account Settings</h2>
              <form action="" class="tm-signup-form row" id="reply"  >
                <div class="form-group col-lg-6">
                  <label for="id">Account ID</label>
                  <input
                          id="id"
                          name="id"
                          type="text"
                          class="form-control validate"
                          value="<%= stu.getUsername()%>" readonly="readonly"
                          style="color: black"
                  />
                </div>
                <div class="form-group col-lg-6">
                  <label for="name">Account Name</label>
                  <input
                          id="name"
                          name="name"
                          type="text"
                          class="form-control validate"
                          value="<%= stu.getName()%>" readonly="readonly"
                          style="color: black"
                  />
                </div>
                <div class="form-group col-lg-6">
                  <label for="password">Password</label>
                  <input
                          id="password"
                          name="password"
                          type="password"
                          class="form-control validate"
                  />
                </div>
                <div class="form-group col-lg-6">
                  <label for="password2">Re-enter Password</label>
                  <input
                          id="password2"
                          name="password2"
                          type="password"
                          class="form-control validate"
                  />
                </div>
                <div class="form-group mb-3">
                  <label
                          for="category"
                  >Department</label
                  >
                  <select
                          class="custom-select tm-select-accounts"
                          id="category"
                          name="category"
                  >
                    <option selected>Department category</option>
                    <option value="人事部">人事部</option>
                    <option value="保卫部">保卫部</option>
                    <option value="财务部">财务部</option>
                    <option value="技术部">技术部</option>
                    <option value="管理部">管理部</option>
                  </select>
                </div>
                <div class="form-group col-lg-6">
                  <label class="tm-hide-sm">&nbsp;</label>
                  <button
                          type="submit"
                          class="btn btn-primary btn-block text-uppercase"

                          onclick="return a();"
                  >
                    Update Your Profile
                  </button>
                </div>
                <div class="col-12">
                  <button
                          type="submit"
                          class="btn btn-primary btn-block text-uppercase" onclick="return b();">
                    Delete Your Account
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <footer class="tm-footer row tm-mt-small">
        <div class="col-12 font-weight-light">
          <p class="text-center text-white mb-0 px-4 small">
            Copyright &copy; <b>2018</b> All rights reserved. 
            
            More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
          </p>
        </div>
      </footer>
    </div>

    <script src="js/jquery-3.3.1.min.js"></script>
  <script language="javascript">
    function a(){
      document.getElementById("reply").action="/servlet/AlterMessage?id=<stu.getUsername()>";


    }
    function b(){
      document.getElementById("reply").action="/servlet/Delete_Message?id=<stu.getUsername()>";


    }
  </script>
    <!-- https://jquery.com/download/ -->
    <script src="js/bootstrap.min.js"></script>
    <!-- https://getbootstrap.com/ -->
  </body>
</html>
