<%@ page language="java" import="java.util.*" import="Servlet.*" import="Bean.*" pageEncoding="UTF-8"%> <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Add Product - Dashboard HTML Template</title>
    <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
    />
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link rel="stylesheet" href="css/fontawesome.min.css" />
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="jquery-ui-datepicker/jquery-ui.min.css" type="text/css" />
    <!-- http://api.jqueryui.com/datepicker/ -->
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="css/templatemo-style.css">

</head>

<body>
<%
    Users stu = (Users)session.getAttribute("User");
%>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container tm-mt-big tm-mb-big">
    <div class="row">
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
            <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                <div class="row">
                    <div class="col-12">
                        <h2 class="tm-block-title d-inline-block">Register successful</h2>
                    </div>
                </div>
                <div class="row tm-edit-product-row">
                    <div class="col-xl-6 col-lg-6 col-md-12">
                        <form action="/servlet/Require_Message" class="tm-edit-product-form">
                            <div class="form-group mb-3">
                                <label
                                        for="name"
                                >Account's Name
                                </label>
                                <textarea
                                        rows = "1"
                                        class="form-control validate"
                                        value=""
                                        required
                                ><%=stu.getName()%></textarea>
                            </div>
                            <div class="form-group mb-3">
                                <label
                                        for="id"
                                >Account id</label
                                >
                                <textarea
                                        rows = "1"
                                        class="form-control validate"
                                        value = "89757"
                                        required
                                ><%=stu.getUsername()%></textarea>
                            </div>
                            <div class="form-group mb-3">
                                <label
                                        for="password2"
                                >Password</label
                                >
                                <textarea
                                        rows = "1"
                                        class="form-control validate"
                                        value=""
                                        required
                                ><%=stu.getMypassword()%></textarea>
                            </div>
                            <div class="form-group mb-3">
                                <label
                                        for="category"
                                >Department</label
                                >
                                <<textarea
                                    rows = "1"
                                    class="form-control validate"
                                    value=""
                                    required
                            ><%=stu.getDepartment()%></textarea>
                            </div>


                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                        <div class="tm-product-img-dummy mx-auto">
                            <i
                                    class="fas fa-cloud-upload-alt tm-upload-icon"
                                    onclick="document.getElementById('fileInput').click();"
                            ></i>
                        </div>
                        <div class="custom-file mt-3 mb-3">
                            <input id="fileInput" type="file" style="display:none;" />

                        </div>
                    </div>
                    <div class="col-12">
                        <button type="submit" class="btn btn-primary btn-block text-uppercase">Complete</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<footer class="tm-footer row tm-mt-small">
    <div class="col-12 font-weight-light">
    </div>
</footer>

<script src="js/jquery-3.3.1.min.js"></script>
<!-- https://jquery.com/download/ -->
<script src="jquery-ui-datepicker/jquery-ui.min.js"></script>
<!-- https://jqueryui.com/download/ -->
<script src="js/bootstrap.min.js"></script>
<!-- https://getbootstrap.com/ -->
<script>
    $(function() {
        $("#expire_date").datepicker();
    });
</script>
</body>
</html>