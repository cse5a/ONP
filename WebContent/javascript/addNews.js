function Image1()
	{
		var Image1type = document.getElementById('postImage1').files[0].type;
	var Image1size = document.getElementById('postImage1').files[0].size;
	if(Image1type!='image/jpeg')
	{
		document.getElementById('image11').style.display="block";
	}
	if(Image1size>=20971520)
	{
		document.getElementById('image12').style.display="block";

	}
	if(Image1type=='image/jpeg')
	{
		document.getElementById('image11').style.display="none";
	}
	if(Image1size<20971520)
	{
		document.getElementById('image12').style.display="none";

	}
}
function Image2()
{
	var Image1type = document.getElementById('postImage2').files[0].type;
	var Image1size = document.getElementById('postImage2').files[0].size;
	if(Image1type!='image/jpeg')
	{
		document.getElementById('image21').style.display="block";
	}
	if(Image1size>=20971520)
	{
		document.getElementById('image22').style.display="block";
	}
	if(Image1type=='image/jpeg')
	{
		document.getElementById('image21').style.display="none";
	}
	if(Image1size<20971520)
	{
		document.getElementById('image22').style.display="none";

	}
}
function Video1()
{
	var Image1type = document.getElementById('postVideo1').files[0].type;
	var Image1size = document.getElementById('postVideo1').files[0].size;
	if(Image1type!='video/mp4')
	{
		document.getElementById('image31').style.display="block";
	}
	if(Image1size>=20971520)
	{
		document.getElementById('image32').style.display="block";
	}
	if(Image1type=='video/mp4')
	{
		document.getElementById('image31').style.display="none";
	}
	if(Image1size<20971520)
	{
		document.getElementById('image32').style.display="none";

	}
}
function checkFiles()
{
	var Image1type = document.getElementById('postImage1').files[0].type;
	var Image2type = document.getElementById('postImage2').files[0].type;
	var Video1type = document.getElementById('postVideo1').files[0].type;
	var Image1size = document.getElementById('postImage1').files[0].size;
	var Image2size = document.getElementById('postImage2').files[0].size;
	var Video1size = document.getElementById('postVideo1').files[0].size;
	if(Image1type!='image/jpeg' || Image2type!='image/jpeg' || Video1type!='video/mp4')
	{
		return false;
	}
	if(Image1size>=20971520 || Image2size>=20971520 || Video1size>=20971520)
	{
		return false;
	}
	return true;
}