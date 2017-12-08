
<div class="container">
	<div class="row">

		<!-- Would be to display side bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- Actual Display Products -->
		<div class="col-md-9">
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClickAllProducts==true}">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>
				</div>

				<c:if test="${userClickCategoryProducts==true}">
					<script>
						window.categoryId = '${category.id}';
					</script>
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">Category</li>
						<li class="active">${category.name}</li>
					</ol>
				</c:if>

			</div>


			<div class="row">
				<div class="col-xs-12">
				
				    <div class="container-fluid">
                            
                            <div class="table-responsive">
                              
                              <table id="productListTable"
						class="table table-striped table-borderd">

						<thead>
							<tr>
							<th class="img-responsive"></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity Available</th>
								
								<th></th>
								
							</tr>
						</thead>
						
						<tfoot>
							<tr>
							<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity Available</th>
				                
				                <th></th>
							</tr>
						</tfoot>
					</table>
                              
                            </div>
                       
                       </div>
				
					
				</div>
			</div>
		</div>


	</div>
</div>

