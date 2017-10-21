function resizeIframe() 
{
	var obj=document.getElementById("myframe");
    obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
}