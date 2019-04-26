<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Property</title>
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
<div class="" id="home">
    <jsp:include page="Header.jsp"></jsp:include>
</div>

</div>
<div class="container mt-5">
    <div class="row tm-content-row">
        <div class="col-12 tm-block-col">
            <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                <p class="text-white">&nbsp;</p>
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
                <form action="/servlet/AddEmployee" class="tm-signup-form row">
                    <div class="form-group col-lg-6">
                        <label for="name">Account Name</label>
                        <input
                                id="name"
                                name="name"
                                type="text"
                                class="form-control validate"
                        />
                    </div>
                    <div class="form-group col-lg-6">
                        <label for="id">Account Id</label>
                        <input
                                id="id"
                                name="id"
                                type="text"
                                class="form-control validate"
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
                        >
                            ADD New Employee
                        </button>
                    </div>
                    <div class="col-12">

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<footer class="tm-footer row tm-mt-small">
    <div class="col-12 font-weight-light">

    </div>
</footer>
</div>

<script src="js/jquery-3.3.1.min.js"></script>
<!-- https://jquery.com/download/ -->
<script src="js/bootstrap.min.js"></script>
<!-- https://getbootstrap.com/ -->
</body>
</html>
