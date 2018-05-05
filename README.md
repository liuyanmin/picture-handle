# picture-handle
<h2>使用java操作图片demo，可以实现java画个性化海报</h2><br/>

提供了两个demo，一个是使用java提供的Graphics2D实现画海报，一个是使用google开元的Thumbnailator工具类操作图片。<br/>
基本功能可以使用Thumbnailator操作图片，但是定制化的东西它无法完成，所以Thumbnailator可以与Graphics2D结合使用。<br/><br/>


<h2>本项目提供了一个完整的生产上使用的例子，功能就是根据用户信息给用户定制化海报。</h2>Graphics2DDemo.java<br/>
<h3>本例子涉及到的功能点有：</h3><br/>
 1、背景图上添加图片<br/>
 2、图片去掉棱角<br/>
 3、画圆形头像<br/>
 4、图片上写字<br/><br/>
 
 <h3>Thumbnailator提供的功能有：</h3><br/>
 1、缩放图片（指定比例）<br/>
 2、缩放图片（非指定比例）<br/>
 3、压缩图片<br/>
 4、裁剪图片<br/>
 5、旋转图片<br/>
 6、添加水印（可以设置透明度）<br/>
 7、批量处理图片<br/><br/>
 
 使用Thumbnailator时需要先引入jar包：<br/>
 
 &lt;dependency&gt;<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&lt;groupId><b>net.coobird</b>&lt;/groupId&gt;<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&lt;artifactId><b>thumbnailator</b>&lt;/artifactId&gt;<br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&lt;version><b>0.4.8</b>&lt;/version&gt;<br/>
&lt;/dependency&gt;<br/>

