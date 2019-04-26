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
    <title>Product Page - Admin HTML Template</title>
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
  <jsp:include page="Header.jsp"></jsp:include>
    <div class="container mt-5">
      <div class="row tm-content-row">
        <div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col">
          <div class="tm-bg-primary-dark tm-block tm-block-products">
            <div class="tm-product-table-container">
              <%
           
         ArrayList<Order> u = (ArrayList<Order>)session.getAttribute("orders");
                if(u!=null)
                {
                  Iterator it = u.iterator();
              %>
              <table class="table table-hover tm-table-small tm-product-table">
                <thead>
                  <tr>
                    <th scope="col">&nbsp;</th>
                    <th scope="col">PRODUCT NAME</th>
                    <th scope="col">UNIT SOLD</th>
                    <th scope="col">IN STOCK</th>
                    <th scope="col">EXPIRE DATE</th>
					 <th scope="col">UNIT SOLD</th>
                    <th scope="col">IN STOCK</th>
                    <th scope="col">EXPIRE DATE</th>
                    <th scope="col">&nbsp;</th>
                  </tr>
                </thead>
                <tbody>
                <%
                  while (it.hasNext())
                  {
                    Users message = (Users)it.next();

                %>
                  <tr>
                    <a><th scope="row"><input type="checkbox" /></th>
                      <td class="tm-product-name"> <a href="/servlet/Modify_Account?id=<%=message.getUsername()%>&sign=<%=0%>" style="color: white"><%=message.getUsername()%></a></td>
                  <td><%=order.getOrderNo()%></td>
         <td><%=order.getAccepter()%></td>
     <td><%=order.getMobile()%></td>
     <td><%=order.getOrderAddress()%></td>
     <td><%=order.getSubmitTime()%></td>
     <td><%=order.getTotalPrice()%></td>
     <td><%=order.getFinalPrice()%></td>
      <td class="td-orderStatus"><span class="label label-success radius"><%=order.getStatus()%></span></td>
     <td>
                      <a href="/servlet/Delete_Message?id=<%=message.getUsername()%>" class="tm-product-delete-link">
                        <i class="far fa-trash-alt tm-product-delete-icon"></i>
                      </a>
                    </td>
                    </a>
                  </tr>
                </tbody>
                <%
                  }  }
                %>
              </table>
            </div>
            <!-- table container -->
            <a
              href="sign_up.jsp"
              class="btn btn-primary btn-block text-uppercase mb-3">Add new employee</a>

          </div>
        </div>
        <div class="col-sm-12 col-md-12 col-lg-4 col-xl-4 tm-block-col">
          <div class="tm-bg-primary-dark tm-block tm-block-product-categories">
            <h2 class="tm-block-title">Employee Categories</h2>
            <div class="tm-product-table-container">
              <%
                ArrayList<String> u1 = (ArrayList<String>)session.getAttribute("String");
                if(u1!=null)
                {
                  Iterator it = u1.iterator();
              %>
              <table class="table tm-table-small tm-product-table">
                <%
                  while (it.hasNext())
                  {
                    String message = (String)it.next();

                %>
                <tbody>
                  <tr>
                    <td class="tm-product-name"><%System.out.println("hihihihih");%>
                      <%=message%></td>
                    <td class="text-center">
                      <a href="/servlet/Delete_Cata?id=<%=message%>" class="tm-product-delete-link">
                        <i class="far fa-trash-alt tm-product-delete-icon"></i>
                      </a>
                    </td>
                  </tr>
                </tbody>
                <%
                    }  }
                %>
              </table>
            </div>
            <!-- table container -->
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

    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- https://jquery.com/download/ -->
    <script src="js/bootstrap.min.js"></script>
    <!-- https://getbootstrap.com/ -->

  </body>
</html>