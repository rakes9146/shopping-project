  <head>

        <style>
            #btn-submit{padding: 10px 20px;background: #555;border: 0;color: #FFF;display:inline-block;margin-top:20px;cursor: pointer;}
            #btn-submit:disabled{padding: 10px 20px;background: #CCC;border: 0;color: #FFF;display:inline-block;margin-top:20px;cursor: no-drop;}
            .validation-error {color:#FF0000;}
            .input-control{padding:10px;}
            .input-group{margin-top:10px;}
        </style>

        <link href="bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="bootstrap.js" type="text/javascript"></script>
        <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    </head>

<body>
	<%@include file="../../shared/flow-header.jsp"%>
	<br />
	<br />

	<!--

//-->

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
					   <form id="paymentForm" role="form" method="get">
                        <div class="form-group">
                            <label for="cardNumber"> CARD NUMBER <span class="cardNumber-validation validation-error"></span></label>
                            <div class="input-group">
                                <input type="text" class="form-control"  name="cardNumber" id="cardNumber"
                                       placeholder="Valid Card Number" maxlength="16" onblur="validate()" /> <span
                                       class="input-group-addon"><span
                                        class="glyphicon glyphicon-lock"></span></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-7 col-md-7">
                                <div class="form-group">
                                    <label for="expityMonth">EXPIRY DATE <span class="expiryMonth-validation validation-error"> </span><br/><span class="expiryYear-validation validation-error"> </span></label><br />
                                    <div class="col-xs-6 col-lg-6 pl-ziro">
                                        <input type="text" class="form-control" id="expiryMonth" name="expiryMonth" onblur="validate()"
                                               placeholder="MM" required  maxlength="2"/>
                                    </div>
                                    <div class="col-xs-6 col-lg-6 pl-ziro">
                                        <input type="text" class="form-control" name="expiryYear" id="expiryYear"
                                               placeholder="YYYY"  maxlength="4" onblur="validate()" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-5 col-md-5 pull-right">
                                <div class="form-group">
                                    <label for="cvCode"> CVV</label> <span class="cvv-validation validation-error"></span><input type="password" id="cvv" name="cvv"
                                                                                                                                 class="form-control" id="cvv" name="cvv" placeholder="CV"  onblur="validate()"
                                                                                                                                 maxlength="3" />
                                </div>
                            </div>
                        </div>

                        <ul class="nav nav-pills nav-stacked">
                            <li class="active"><a href="#"><span
                                        class="badge pull-right"> &#8377;
                                        ${checkoutModel.checkoutTotal}/-</span> Final Payment</a></li>
                        </ul>
                        <br /> <a  href="${flowExecutionUrl}&_eventId_pay" disabled="disabled" onblur="validate()"
                                       id="submitButton" class="btn btn-success btn-lg btn-block"
                                       role="button">Pay</a>

                    </form>

                    <script>
                        function validate() {

                            var valid = true;
                            valid = checkEmpty($("#cardNumber"));
                            valid = valid && checkCard($("#cardNumber")) && checkMonth($("#expiryMonth")) && checkYear($("#expiryYear")) && checkCVV($("#cvv"));


                            $("#submitButton").attr("disabled", true);
                            if (valid) {
                                $("#submitButton").attr("disabled", false);
                            }
                        }
                        function checkEmpty(obj) {
                            var cardNumber = $(obj).attr("name");
                            $("." + cardNumber + "-validation").html("");
                            $(obj).css("border", "");
                            if ($(obj).val() == "") {
                                $(obj).css("border", "#FF0000 1px solid");
                                $("." + cardNumber + "-validation").html("Required");
                                return false;
                            }

                            return true;
                        }

                        function checkCard(obj) {

                            var result = true;

                            var cardNumber = $(obj).attr("name");
                            $("." + cardNumber + "-validation").html("");
                            $(obj).css("border", "");

                            var card_regex = /^\d{16}$/;
                            result = card_regex.test($(obj).val());

                            if (!result) {
                                $(obj).css("border", "#FF0000 1px solid");
                                $("." + cardNumber + "-validation").html("<strong>Invalid Card Number</strong>");
                                return false;
                            }
                            result = checkEmpty(obj);


                            return result;

                        }
                        function checkMonth(obj) {
                            var result = true;

                            var expiryMonth = $(obj).attr("name");
                            $("." + expiryMonth + "-validation").html();
                            $(obj).css("border", "");

                            result = checkEmpty(obj);

                            if (!result) {
                                $(obj).css("border", "#FF0000 1px solid");
                                $("." + expiryMonth + "-validation").html("Required");
                                return false;
                            }
                            
                             var d = new Date();
                             if ($(obj).val() > d.getMonth()) {
                             result = false;
                             }
                             if (!result) {
                             $(obj).css("border", "#FF0000 1px solid");
                             $("." + expiryMonth + "-validation").html("<strong>Invalid Month</strong>");
                             return false;
                             }
                                
                           

                           

                            return result;
                        }

                        function checkYear(obj) {
                            var result = true;



                            var expiryYear = $(obj).attr("name");
                            $("." + expiryYear + "-validation").html("");
                            $(obj).css("border", "");

                            result = checkEmpty(obj);

                            if (!result) {
                                $(obj).css("border", "#FF0000 1px solid");
                                $("." + expiryYear + "-validation").html("Required");
                                return false;
                            }

                            var d = new Date();
                            if ($(obj).val() <= d.getFullYear()) {
                                result = false;
                            }

                            if (!result) {
                                $(obj).css("border", "#FF0000 1px solid");
                                $("." + expiryYear + "-validation").html("<strong>Invalid Year</strong>");
                                return false;
                            }



                            return result;
                        }

                        function checkCVV(obj) {
                            var result = true;

                            var cvv = $(obj).attr("name");
                            $("." + cvv + "-validation").html("");
                            $(obj).css("border", "");

                            result = checkEmpty(obj);
                            
                              var cvv_regex = /^\d{3}$/;
                            result = cvv_regex.test($(obj).val());

                            if (!result) {
                                $(obj).css("border", "#FF0000 1px solid");
                                $("." + cvv + "-validation").html("<strong>Invalid CVV Number</strong>");
                                return false;
                            }
                         result = checkEmpty(obj);


                        //    return result;



                            return result;
                        }


                        function checkEmail(obj) {
                            var result = true;

                            var name = $(obj).attr("name");
                            $("." + name + "-validation").html("");
                            $(obj).css("border", "");

                            result = checkEmpty(obj);

                            if (!result) {
                                $(obj).css("border", "#FF0000 1px solid");
                                $("." + name + "-validation").html("Required");
                                return false;
                            }

                            var email_regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,3})+$/;
                            result = email_regex.test($(obj).val());

                            if (!result) {
                                $(obj).css("border", "#FF0000 1px solid");
                                $("." + name + "-validation").html("Invalid");
                                return false;
                            }

                            return result;
                        }
                    </script>	
					</div>
				</div>

			</div>

		</div>
	</div>
	<!-- 
	<button id="myBtn" disabled="true">My Button</button>

<p>Click the button below to disable the button above.</p>

<button onclick="myFunction()">Try it</button>
 
<script>
function myFunction() {
    document.getElementById("submitButton1").disabled = false;
}
</script>
-->



	<%@include file="../../shared/flow-footer.jsp"%>
</body>