<%@include file="../../shared/flow-header.jsp"%>
<br />
<br />
<div class="container">

	<div class="row">
		<!--  To display all the goods -->
		<div class="col-md-6">

			<div class="row">
				<c:forEach items="${checkoutModel.cartLines}" var="cartLine">
					<div class="col-xs-12">

						<div>
							<h3>${cartLine.product.name}</h3>
							<hr />
							<h4>Quantity -${cartLine.productCount}</h4>
							<h5>Buying Price - &#8377; ${cartLine.buyingPrice}/-</h5>
						</div>
						<hr />
						<div class="text-right">
							<h3>Grand Total - &#8377; ${cartLine.total}/-</h3>
						</div>
					</div>
				</c:forEach>
			</div>


		</div>

		<div class="col-md-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Payment Details</h3>
				</div>
				<div class="panel-body">
					<form id="paymentForm" role="form">
						<div class="form-group">
							<label for="cardNumber"> CARD NUMBER</label>
							<div class="input-group">
								<input type="text" class="form-control" id="cardNumber"
									placeholder="Valid Card Number" maxlength="12" /> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-lock"></span></span>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-7 col-md-7">
								<div class="form-group">
									<label for="expityMonth">EXPIRY DATE</label> <br />
									<div class="col-xs-6 col-lg-6 pl-ziro">
										<input type="text" class="form-control" id="expityMonth"
											placeholder="MM" max="1" min="12" maxlength="2" required />
									</div>
									<div class="col-xs-6 col-lg-6 pl-ziro">
										<input type="text" class="form-control" id="expityYear"
											placeholder="YY" required maxlength="4" />
									</div>
								</div>
							</div>
							<div class="col-xs-5 col-md-5 pull-right">
								<div class="form-group">
									<label for="cvCode"> CV CODE</label> <input type="password"
										class="form-control" id="cvCode" placeholder="CV" required
										maxlength="3" />
								</div>
							</div>
						</div>

						<ul class="nav nav-pills nav-stacked">
							<li class="active"><a href="#"><span
									class="badge pull-right"> &#8377;
										${checkoutModel.checkoutTotal}/-</span> Final Payment</a></li>
						</ul>
						<br /> <a href="${flowExecutionUrl}&_eventId_pay"
							class="btn btn-success btn-lg btn-block" role="button">Pay</a>

					</form>
				</div>
			</div>

		</div>

	</div>
</div>


<script src="${js}/jquery.js"></script>
<script src="${js}/jquery.validate.js"></script>

<script src="${js}/app.js"></script>

<%@include file="../../shared/flow-footer.jsp"%>