$(function(){
		var types = $("#types").children();
		var mark = $("#mark");
		for(var i =0;i<types.length;i++){
			console.log(types[i]);
			$(types[i]).click(function(){
				mark.val("");
				 var type = $.trim($(this).children("span").text());
				mark.val(type+' ');
			})
		}
})