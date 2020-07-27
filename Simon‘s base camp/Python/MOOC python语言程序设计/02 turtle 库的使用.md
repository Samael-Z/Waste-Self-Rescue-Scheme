```
#PythonDraw.py 蟒蛇绘制图形是一切图形绘制的基础
import turtle
turtle.setup(650, 350, 200, 200)
turtle.penup()
turtle.fd(-250)
turtle.pendown()
turtle.pensize(25)
turtle.pencolor("purple")
turtle.seth(-40) #向👉转
for i in range(4)
    turtle.circle(40, 80)
    turtle.circle(-40, 80)
turtle.circle(40, 80/2)
turtle.fd(40)
turtle.circle(16, 180)
turtle.fd(40 * 2/3)
turtle.done()
```
> 举一反三，七彩🐍，五角星等等东西

#### 标准库

python计算生态 = 标准库 + 第三方库

> 第三方库是需要经过安装才能使用的功能模块。我们经常用到库`Library`、包`Package`、模块`Module`，初学阶段统称为**模块**

![]()

#### turtle的绘图窗体

`turtle.setup(width, height, startx, starty)`

setup()设置窗体大小及位置，后两个参数可选。setup()并非必须的。如果没有设定位置，系统会默认窗体在屏幕的正中心。

#### turtle空间坐标体系

绝对坐标和屏幕空间坐标不同

###### 绝对坐标

中心为(0, 0)，可以用`turtle.goto(x, y)`来实现直线的一个绘制

###### 海🐢方向

右边为海右边为海🐢的前方
```
turtle.circle(r, anggle)
turtle.bk(d)
turtle.fd(d)
```

```
import turtle
turtle.left(45)
turtle.fd(150）
turtlle.right(135)
turtle.fd(300)
turtle.left(135)
turtle.fd(150)
```

#### RGB色彩体系

由三种颜色形成的万物色，RGB每色取值范围0~255整数或者0~1小数

|英文名称|RGB|RGB|中文|
|:---:|:---:|:---:|:---:|
|white|255, 255, 255|1, 1, 1|白色|
|yellow|255, 255, 0|1, 1, 0|黄色|
|magenta|255, 0, 255|1, 0, 1|洋红|
|cyan|0, 255, 255|0, 1, 1|青色|
|blue|0, 0, 255|0, 0, 1|蓝色|
|black|0, 0, 0|0, 0, 0|黑色|
|gold|255, 215, 0|1, 0.84, 0|金色|
|purple|160, 32, 240|0.63, 0.13, 0.94|紫色|

###### turtle.colormode(mode)
1.0：RGB小数值模式
255：RGB整数值模式
