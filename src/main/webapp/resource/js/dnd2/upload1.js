window.addEventListener("load", function() {
	var section = this.document.querySelector("#upload");
	var dropZone = section.querySelector(".drop-zone");
	var fileButton = section.querySelector("input[type=file]");
	var trigButton = section.querySelector(".triger");
	var percentSpan = section.querySelector(".percent");
	var progressDiv = section.querySelector(".progress");

	dropZone.addEventListener("dragenter", function(e) {
	
	});
	dropZone.addEventListener("dragleave", function(e) {
	
	});
	dropZone.addEventListener("dragover", function(e) {
		e.preventDefault();
		console.log("gkdl");
	
	});

	dropZone.addEventListener("drop", function(e) {
		e.preventDefault();

	
	});


});