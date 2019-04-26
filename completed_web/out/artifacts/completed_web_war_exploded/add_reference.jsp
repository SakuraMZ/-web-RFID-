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
    <title>Add Reference - Dashboard Admin Template</title>
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
  <jsp:include page="Header.jsp"></jsp:include>
    <div class="container tm-mt-big tm-mb-big">
      <div class="row">
        <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
          <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
            <div class="row">
              <div class="col-12">
                <h2 class="tm-block-title d-inline-block">Add_Reference</h2>
              </div>
            </div>
            <div class="row tm-edit-product-row">
              <div class="col-xl-6 col-lg-6 col-md-12">
                <form action="/servlet/Add_Meeting" method="post" class="tm-edit-product-form">
                  <div class="form-group mb-lg-3">
                    <label
                      for="name"
                      >Reference Name
                    </label>
                    <input
                      id="name"
                      name="name"
                      type="text"
                      value=""
                      class="form-control validate"
                    />
                  </div>
				  <div class="form-group mb-lg-3">
                    <label
                      for="id"
                      >Reference Id
                    </label>
                    <input
                      id="id"
                      name="id"
                      type="text"
                      value=""
                      class="form-control validate"
                    />
                  </div>
                  <div class="form-group mb-lg-3">
                    <label for="description"
                      >Description</label
                    >
                    <textarea
                            id="description"
                            name="description"
                      class="form-control validate tm-small"
                      rows="5"
                      required
                    >  </textarea>
                  </div>
                  

                      <div class="form-group mb-lg-3">
                          <label
                            for="expire_date"
                            >Start Time
                          </label>
                          <input
                            id="expire_date"
                            name="expire_date"
                            type="text"
                            class="form-control validate"
                            value=""
                          />
                        </div>
                        <div class="form-group mb-lg-3">
                          <label
                            for="stock"
                            >Location
                          </label>
                          <input
                            id="stock"
                            name="stock"
                            type="text"
                            value=""
                            class="form-control validate"
                          />
                        </div>

                  

             
              <div class="col-12">
                <button type="submit" class="btn btn-primary btn-block text-uppercase">Add Now</button>
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

  </body>
</html>
