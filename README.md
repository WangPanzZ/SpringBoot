# SpringBoot
1、Spring Boot：配置文件的优先级<br>
application.properties和application.yml文件可以放在一下四个位置：<br>
外置，在相对于应用程序运行目录的/congfig子目录里<br>
外置，在应用程序运行的目录里<br>
内置，在config包内<br>
内置，在Classpath根目录<br>
同样，这个列表按照优先级排序，也就是说，src/main/resources/config下application.properties覆盖src/main/resources下application.properties中相同的属性，
此外，如果你在相同优先级位置同时有application.properties和application.yml，那么application.yml里面的属性就会覆盖application.properties里的属性。