<div class="container">
   <div class="row">
   
       <!-- Would be to display side bar -->
       <div class = "col-md-3">
         <%@include file="./shared/sidebar.jsp" %>
       </div>
       
       <!-- Actual Display Products -->
       <div class="col-md-9">
             <div class="row">
                 <div class="col-lg-12">
                 
                 <c:if test="${userClickAllProducts==true}">
                   <ol class="breadcrumb">
                     <li><a href="${contextRoot}/home">Home</a></li>
                      <li class="active">All Products</li>
                   </ol>
                   </c:if>
                 </div>
                 
                    <c:if test="${userClickCategoryProducts==true}">
                   <ol class="breadcrumb">
                     <li><a href="${contextRoot}/home">Home</a></li>
                      <li class="active">Category</li>
                        <li class="active">${category.name}</li>
                   </ol>
                   </c:if>
                 </div>
                 
                 
             </div>
             
             
       </div>
       
        <!--  To display the actual products -->
        <div class="col-md-9">
           <div class="row">
               <div class="col-xs-12">
                    <table id="productListTable" class="table table-striped table-borderd">
                       
                       <thead>
                           <tr>
                              <th> Id</th>
                              <th> Name</th>
                           </tr>
                       </thead>
                    </table>
               </div>
           </div>
        </div>
   </div>
</div>