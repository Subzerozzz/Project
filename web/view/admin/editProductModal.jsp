<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <!-- Modal -->
 <div class="modal fade" id="editProductModal" tabindex="-1" role="dialog" aria-labelledby="addModal" aria-hidden="true">
     <div class="modal-dialog" role="document">
         <div class="modal-content">
             <div class="modal-header">
                 <h5 class="modal-title" id="addBookModalLabel">Edit</h5>
                 <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                 </button>
             </div>
             <div class="modal-body">
                 <form id="updateProductForm" action="product?action=update" method="POST" enctype="multipart/form-data">
                     <!--id-->
                    <div class="form-group">
                        <label for="id">ID:</label>
                        <input type="text" class="form-control" id="idInput" name="id">
                        <div id="nameError" class="error"></div>
                    </div>
                     <!--Name-->
                     <div class="form-group">
                         <label for="name">Name:</label>
                         <input type="text" class="form-control" id="nameInput" name="name">
                         <div id="nameError" class="error"></div>
                     </div>
                     <!--Price-->
                     <div class="form-group">
                         <label for="price">Price:</label>
                         <input type="text" class="form-control" id="priceInput" name="price">
                         <div id="priceError" class="error"></div>
                     </div>
                     <!--Quantity-->
                     <div class="form-group">
                         <label for="quantity">Quantity:</label>
                         <input type="text" class="form-control" id="quantityInput" name="quantity">
                         <div id="quantityError" class="error"></div>
                     </div>
                     <!--Category-->
                     <div class="form-group">
                         <label for="category">Category: </label>
                         <div class="input-group">
                             <select class="custom-select" id="category" name="category">
                                 <c:forEach items="${listCategory}" var='item'>
                                     <option value="${item.category_id}">${item.category_name}</option> 
                                 </c:forEach>
                             </select>
                             <div class="input-group-append">
                                 <button class="btn btn-outline-secondary" type="button">Category</button>
                             </div>
                         </div>
                     </div>
                     <!--Image-->
                     <div class="form-group">
                         <label for="image">Image: </label>
                         <div class="input-group mb-3">
                             <div class="input-group-prepend">
                                 <span class="input-group-text">Upload</span>
                             </div>
                             <div class="custom-file">
                                 <input type="file" class="custom-file-input" id="image" name="image" onchange="displayImage(this)">
                                 <label class="custom-file-label" >Choose file</label>
                             </div>
                         </div>
                         <img id="previewImage" src="#" alt="Preview"
                              style="display: none; max-width: 300px; max-height: 300px;">
 
                     </div>
                     <!--Description-->
                     <div class="form-group">
                         <label for="description">Description:</label>
                         <textarea class="form-control" name="description"></textarea>
                     </div>
                 </form>
             </div>
             <div class="modal-footer">
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                 <button type="submit" class="btn btn-primary" form="addProductForm" onclick="validateForm2()">Update</button>
             </div>
         </div>
     </div>
 </div>

<script>
    function updateProductModal(e){
        const tr = e.closest("tr");

        //lấy ra dữ liệu
        let id = tr.querySelector("td[name='id']").innerHTML.trim();
        let name = tr.querySelector("td[name='name']").innerHTML.trim();
        let price = tr.querySelector("td[name='price']").innerHTML.trim();
        let quantity = tr.querySelector("td[name='quantity']").innerHTML.trim();
        let categoryId = tr.querySelector("td[name='category']").querySelector("p").innerHTML.trim();
        //đắp dữ liệu lên form
        let updateForm = document.querySelector("#updateProductForm")
        let inputID = updateForm.querySelector("input[name='id']").value = id
        let inputName = updateForm.querySelector("input[name='name']").value = name
        let inputPrice = updateForm.querySelector("input[name='price']").value = price
        let inputQuantity = updateForm.querySelector("input[name='quantity']").value = quantity
        let inputCategory =updateForm.querySelector("select[name='category']").value = categoryId
    }
    
    function validateForm2() {
        let name = $('#nameEditInput').val();
        let price = $('#priceEditInput').val();
        let quantity = $('#quantityEditInput').val();

        //xoá thông báo lỗi hiện tại
        $('.error').html('');

        if (name === '') {
            $('#nameEditError').html('Tên sách không được để trống');
        }

        if (price === '') {
            $('#priceEditError').html('Giá của quyển sách không được để trống');
        } else if (!$.isNumeric(price) || parseFloat(price) < 0) {
            $('#priceEditError').html('Giá của quyển sách phải là số và không được nhỏ hơn 0');
        }

        if (quantity === '') {
            $('#quantityEditError').html('Số lượng sách không được để trống');
        } else if (!$.isNumeric(quantity) || parseInt(price) < 0) {
            $('#priceEditError').html('Số lượng của quyển sách phải là số và không được nhỏ hơn 0');
        }

        // Kiểm tra nếu không có lỗi thì submit form
        let error = '';
        $('.error').each(function () {
            error += $(this).html();
        });
        if (error === '') {
            $('#editBookForm').submit();
        } else {
            event.preventDefault();
        }
    }
</script>