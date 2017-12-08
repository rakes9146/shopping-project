$(function() {
	switch (menu) {
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'User Cart':
		$('#userCart').addClass('active');
		break;	
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		$("listProducts").addClass("active");
		$("#a_" + menu).addClass('active');
		break;
	}

	// to tackle the csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	if(token.length > 0 && header.length >0){
		$(document).ajaxSend(function(e,xhr,option){
			
			 xhr.setRequestHeader(header,token);
		});
	}
	
	
	// code for jquery table
	var $table = $('#productListTable');

	if ($table.length) {

		var jsonUrl = '';
		if (window.categoryId == '') {

			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';

		}
		// console.log("Inside the table")
		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '5 Records', '5 Records', '10 Records', 'ALL' ] ],
					pageLenght : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg img-responsive"/>'
								}
							},
							{
								data : 'name',
							},
							{
								data : 'brand',
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}
									return data;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

								   if(userRole=='ADMIN'){
									   
										str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
							    
								   }else{
									if (row.quantity < 1) {

										str += '<a href="javascript(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									} else {

										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}
								   }
									return str;
								
								}	   
							},

					]
				});

	}

	// dismssing the alert after three seocnds
	var $alert = $('.alert');
	if ($alert.lenght) {

		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}

	// ------------------------
	$('.switch input[type="checkbox"]')
			.on(
					'change',
					function() {

						var checkbox = $(this);
						var checked = checkbox.prop('checked');
						var dMsg = (checked) ? 'You Want to activate the Product?'
								: 'You want to deactivate the Product?';
						var value = checkbox.prop('value');

						bootbox
								.confirm({

									size: 'medium',
									title: 'Product Activation and Deactivation',
									message: dMsg,
									callback: function(confirmed) {

										if (confirmed) {

											console.log(value);
											bootbox
													.alert({
														size: 'medium',
														title: 'information',
														message: 'You are going to perform operation on product '
																+ value
													});
										} else {
											checkbox.prop('checked', !checked);
										}
									}
								});

					});
	

	// ----------------------data table for admin-+-----------//
	
	
	
	var $adminProductsTable = $('#adminProductsTable');

	if ($adminProductsTable.length) {

		var jsonUrl = window.contextRoot+'/json/data/admin/all/products';
		
		
		// console.log("Inside the table")
		$adminProductsTable
				.DataTable({
					lengthMenu : [ [ 10, , 30, 50,-1 ],
							[ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLenght : 30,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
						
						   {
							   data: 'id'
						   },
						
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>'
								}
							},
							{
								data : 'name',
							},
							{
								data : 'brand',
							},
							
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}
									return data;
								}
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'active',
								bSortable: false,
								mRender: function(data,type,row){
								
								var str='';
								str += '<label class="switch">';
								if(data){
									str +=  '<input type="checkbox" checked="checked" value="'+row.id+'"/>'	
								}else{
									str +=  '<input type="checkbox" value="'+row.id+'"/>'	
								}
								
							    str += '<div class="slider"></div></label>';
								return str;
								}
							},
							
							{
								data:'id',
								bSortable:false,
								mRender:function(data,type,row){
									
									var str='',
									
								str ='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">'
					                str += '<span class="glyphicon glyphicon-pencil"></span></a>'
								return str;
								}
							
								
							}

					],
					initComplete: function(){
						
					  var api = this.api();
					  api.$('.switch input[type="checkbox"]')
						.on(
								'change',
								function() {

									var checkbox = $(this);
									var checked = checkbox.prop('checked');
									var dMsg = (checked) ? 'You Want to activate the Product?'
											: 'You want to deactivate the Product?';
									var value = checkbox.prop('value');

									bootbox
											.confirm({

												size: 'medium',
												title: 'Product Activation and Deactivation',
												message: dMsg,
												callback: function(confirmed) {

													if (confirmed) {

														console.log(value);
														var activationUrl = window.contextRoot+ '/manage/product/'+ value +'/activation';
														$.post(activationUrl,function(data){
															bootbox
															.alert({
																size: 'medium',
																title: 'information',
																message: data
															});
														});
														
														
														
													} else {
														checkbox.prop('checked', !checked);
													}
												}
											});

								});
					}
				});

	}

	
	
	
	// -------------------------------------------------------//
	// -------------------------------------------------------//
	
	var $loginForm = $('#loginForm');
	if($loginForm.length){
		 
		 $loginForm.validate({
			
			 rule:{
				 
				 username: {
					 
					 required: true
		       
				 },
				 password:{
					 required:true
				 }
			 },
			 message:{
				 
		          username:{
		        	  required: "Please Enter the user name!",
		        	  email:"Please Enter the Valid Email"
		          },		 
				 
		          password:{
		        	  required:"Please Enter a Password"
		        	  
		          }
			 },
			 errorElement: 'em',
			 errorPlacement: function(error,element){
				 
				 // add the class of help-block
				 error.addClass('help-block')
				 // add the error element after the input element
				 error.insertAfter(element);
			 }
			 
		 });
	}
	
	// validation for category form
    var $categoryForm = $('#categoryForm');
    if($categoryForm.length){
    	
    	$categoryForm.validate({
    		
    		 rules:{
    			  name:{
    				  required:true,
    				  minlength:2
    	          },
    	          description:{
    	        	  required:true
    	          }
    		 },
    		 messages:{
    			 name:{
    				 required: 'Please Add the Category Name!',
    					 minlength: 'The Category name should be less then 2 characters'
    			 },
    			   description:{
    				 required:'Please Add the Category Description',
    				
    			 }
    		 },
    		 errorElement:'em',
    		 errorPlacement:function(error,element){
    			 //add the class of help-block
    			 error.addClass('help-block');
    			 //add the error element after input element
    			 error.insertAfter(element);
    			 
    		 }
    	});
    }
	
    //handling the click evetn of the refersh cart button
    
    $('button[name="refreshCart"]').click(function(){
    	
    	//fetch the cart line id
    	
    	var cartLineId = $(this).attr('value');
    	var countElement = $('#count_' +cartLineId);
    		
    	var originalCount = countElement.attr('value');
    	var currentCount = countElement.val();
    	
    	//work only when the count has changed
    	if(currentCount !== originalCount)
    		
              if(currentCount<1 || currentCount>3){
            	  
            	  //reverting back to  the original count
            	  //user has given value below 1 and above 3
            	  
            	  countElement.val(originalCount);
            	  
            	  bootbox.alert({
            		  
            		 size: 'medium',
            		 title:'Error',
            		 message:'Product Count should be minum 1 and Maximum 3'
            	  });
              }else{
            	  
            	  var updateUrl = window.contextRoot+'/cart/'+cartLineId+'/update?count='+currentCount;
            	  //forward it to the controller
            	  window.location.href = updateUrl;
              }
     
    });
    
    
    //
    
    window.setTimeout(function() {
        $(".alert").fadeTo(500, 0).slideUp(500, function(){
            $(this).remove(); 
        });
    }, 4000);
    
 // validation for payment gateway form
    var $paymentForm = $('#paymentForm');
    if($paymentForm.length){
    	
    	$paymentForm.validate({
    		
    		 rules:{
    			  cardNumber:{
    				  required:true,
    				  minlength:12,
    				  maxlength:12
    	          },
    	          expiryMonth:{
    	        	  required:true,
    	        	  min:1,
    	        	  max:12
    	          },
    	          expiryYear:{
    	        	  required:true,
    	        	  min:2018,
    	        	  max:2035
    	          },
    	          cvCode:{
    	        	  required:true,
    	        	  minlength:3,
    	        	  maxlength:3, 
    	          }
    		 },
    		 messages:{
    			 cardNumber:{
    				 required: 'Please Enter the Card Number',
    					 minlength: 'A Card Should Have 12 Digits',
    						 maxlength: 'Only 12 Digits Allowed'
    			 },
    			 expiryMonth:{
   	        	  required:'Pease Enter Expiry Month',
   	        	  minlenght:"Invalid Value for Month",
   	        	  maxlenght:"Invalid Value for Month"
   	          },
   	          expiryYear:{
   	        	  required:'Pease Enter Expiry Year',
   	        	  min:"Expiry Date Should Not Be Previous Year",
   	        	  max:"Max year Allowed till 2035"
   	          },
   	          cvCode:{
   	        	  required:'Pease Enter CVV Code',
   	        	  min:'Invalid CVV Format',
   	        	  max:'Invalid CVV Format'
   	          }
    		 },
    		 errorElement:'em',
    		 errorPlacement:function(error,element){
    			 //add the class of help-block
    			 error.addClass('help-block');
    			 //add the error element after input element
    			 error.insertAfter(element);
    			 
    		 }
    	});
    }
	
 
 

});


