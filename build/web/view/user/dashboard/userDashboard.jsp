<%-- 
    Document   : dashboard
    Created on : Mar 8, 2025, 8:55:18 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin - Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">

  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/colReorder-bootstrap4.css">

</head>

<body id="page-top">
    <!--Navbar-->
    <jsp:include page="../../common/user/navbar.jsp"></jsp:include>

  <div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="../../common/user/sidebar.jsp"></jsp:include>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <jsp:include page="../../common/user/breadcrumbs.jsp"></jsp:include>


        <!-- DataTables Example -->
         <div class="card mb-3">
           <div class="card-header">
             <i class="fas fa-table"></i>
             Data Table Example
           </div>
           <div class="card-body">
             <div class="table-responsive">
               <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                 <thead>
                   <tr>
                     <th>Id</th>
                     <th>Name</th>
                     <th>Price</th>
                     <th>Image</th>
                     <th>Stock quantity</th>
                     <th>Category</th>
                     <th>Action</th>
                   </tr>
                 </thead>
                 <tfoot>
                   <tr>
                     <th>Id</th>
                     <th>Name</th>
                     <th>Price</th>
                     <th>Image</th>
                     <th>Stock quantity</th>
                     <th>Category</th>
                     <th>Action</th>
                   </tr>
                 </tfoot>
                 <tbody>
                   
                 </tbody>
               </table>
             </div>
           </div>
           <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
         </div>
 
       </div>
      <!-- /.container-fluid -->

      <!-- Sticky Footer -->
      <jsp:include page="../../common/user/footer.jsp"></jsp:include>


    </div>
    <!-- /.content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  

  <!-- Logout Modal-->
  <jsp:include page="../../common/user/logOutModal.jsp"></jsp:include>

  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>
  <script src="${pageContext.request.contextPath}/vendor/datatables/jquery.dataTables.js"></script>
  <script src="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${pageContext.request.contextPath}/js/sb-admin.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/colReorder-bootstrap4-min.js"></script>
  <script src="${pageContext.request.contextPath}/js/colReorder-dataTables-min.js"></script>

  <!-- Demo scripts for this page-->
  <script src="${pageContext.request.contextPath}/js/demo/datatables-demo.js"></script>
  <script src="${pageContext.request.contextPath}/js/demo/chart-area-demo.js"></script>
  <script src="${pageContext.request.contextPath}/js/colReorder-dataTables-min.js"></script>
  <script src="${pageContext.request.contextPath}/js/colReorder-bootstrap4-min.js"></script>
  
  
  <style>
   .error{
      color:red;
    }
  </style>
</body>

</html>
