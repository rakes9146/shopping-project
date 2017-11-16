
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flow-header.jsp"%>
<br />
<br />
	
<div class="container">

	<div class="col-md-6 col-md-offset-3">

		<div class="panel panel-primary">

			<div class="panel-heading">

				<h4>Sign up - Personal</h4>
			</div>

			<div class="panel-body">

				<sf:form method="post" class="form-horizontal" id="registrationForm" modelAttribute="user">

					<div class="form-group">
						<label class="control-label col-md-4">First Name</label>
						<div class="col-md-8">
							<sf:input type="text" path="firstName" class="form-control"
								placeholder="First Name" />
							<sf:errors path="firstName" cssClass="help-block" element="em"></sf:errors>	
						</div>

					</div>

                    <div class="form-group">
						<label class="control-label col-md-4">Last Name</label>
						<div class="col-md-8">
							<sf:input type="text" path="lastName" class="form-control"
								placeholder="Last Name" />
									<sf:errors path="lastName" cssClass="help-block" element="em"></sf:errors>	
						</div>
					</div>
					
						
					<div class="form-group">
						<label class="control-label col-md-4">Email</label>
						<div class="col-md-8">
							<sf:input type="email" path="email" class="form-control"
								placeholder="Email" />
									<sf:errors path="email" cssClass="help-block" element="em"></sf:errors>	
						</div>
						</div>
						
				<div class="form-group">
						<label class="control-label col-md-4">Contact Number</label>
						<div class="col-md-8">
							<sf:input type="text" path="contactNumber" class="form-control"
								placeholder="Contact Number" />
									<sf:errors path="contactNumber" cssClass="help-block" element="em"></sf:errors>	
						</div>

					</div>		
					
				<div class="form-group">
						<label class="control-label col-md-4">Password</label>
						<div class="col-md-8">
							<sf:input type="password" path="password" class="form-control"
								placeholder="Password" />
									<sf:errors path="password" cssClass="help-block" element="em"></sf:errors>	
						</div>

					</div>	
				
				<div class="form-group">
						<label class="control-label col-md-4">Confirm Password</label>
						<div class="col-md-8">
							<sf:input type="password" path="confirmPassword" class="form-control"
								placeholder="Re-Enter Password" />
									<sf:errors path="confirmPassword" cssClass="help-block" element="em"></sf:errors>	
						</div>

					</div>	
					
					<div class="form-group">
					   <label class="control-label col-md-4">Select Role</label>
					     <div class="col-md-8">
					          <label class="radio-inline">
					               <sf:radiobutton path="role" value="USER" checked="checked" />USer 
					          </label> 
					          <label class="radio-inline">
					               <sf:radiobutton path="role" value="SUPPLIER" />Supplier 
					          </label> 
					        </div>     
					     </div> 
				
					
					
                      <div class="form-group">
                         <div class="col-md-offset-4 col-md-8">
                            <button type="submit" class="btn btn-primary"
                            name="_eventId_billing"
                            >
                            Next - Billing<span class="glyphicon glyphicon-chevron-right"></span>
                            </button>
                         </div>
                        
                      </div>
                      
                      
                      
					


				</sf:form>
			</div>

		</div>

	</div>

</div>



<%@include file="../shared/flow-footer.jsp"%>