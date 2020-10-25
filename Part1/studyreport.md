# Vi Java Ant JUnit自学报告
## Vi(Vim)

### 基本介绍
vi(vim)是上Linux非常常用的编辑器，很多Linux发行版都默认安装了vi(vim)。vi(vim)命令繁多但是如果使用灵活之后将会大大提高效率。vi是“visual interface”的缩写，vim是vi IMproved(增强版的vi)。在一般的系统管理维护中vi就够用，如果想使用代码加亮的话可以使用vim。

### 使用模式
vi有3个模式：插入模式、命令模式、低行模式。

- 插入模式：在此模式下可以输入字符，按ESC将回到命令模式。
- 命令模式：可以移动光标、删除字符等。
- 低行模式：可以保存文件、退出vi、设置vi、查找等功能(低行模式也可以看作是命令模式里的)。

### 基本操作

1. 打开文件、保存、关闭文件(vi命令模式下使用)

    - vi filename &nbsp;&nbsp;//打开filename文件
    - :w &nbsp;&nbsp;//保存文件
    - :w xxx.txt &nbsp;&nbsp;//保存至xxx.txt文件
    - :q &nbsp;&nbsp;//退出编辑器，如果文件已修改请使用下面的命令
    - :q! &nbsp;&nbsp;//退出编辑器，且不保存
    - :wq &nbsp;&nbsp;//退出编辑器，且保存文件

2. 插入文本或行(vi命令模式下使用，执行下面命令后将进入插入模式，按ESC键可退出插入模式)
    - a &nbsp;&nbsp;//在当前光标位置的右边添加文本
    - i &nbsp;&nbsp;//在当前光标位置的左边添加文本
    - A &nbsp;&nbsp;//在当前行的末尾位置添加文本
    - I &nbsp;&nbsp;//在当前行的开始处添加文本(非空字符的行首)
    - O &nbsp;&nbsp;//在当前行的上面新建一行
    - o &nbsp;&nbsp;//在当前行的下面新建一行
    - R &nbsp;&nbsp;//替换(覆盖)当前光标位置及后面的若干文本
    - J &nbsp;&nbsp;//合并光标所在行及下一行为一行(依然在命令模式)

3. 移动光标(vi命令模式下使用)
    - 使用上下左右方向键
    - 命令模式：
        - h   向左
        - j   向下 
        - k   向上
        - l  向右

4. 删除、恢复字符或行(vi命令模式下使用)
- x &nbsp;&nbsp;//删除当前字符
- nx &nbsp;&nbsp;//删除从光标开始的n个字符
- dd &nbsp;&nbsp;//删除当前行
- ndd &nbsp;&nbsp;//向下删除当前行在内的n行
- u &nbsp;&nbsp;//撤销上一步操作
- U &nbsp;&nbsp;//撤销对当前行的所有操作

5. 搜索(vi命令模式下使用)
- /vpser &nbsp;&nbsp;//向光标下搜索vpser字符串
- ?vpser &nbsp;&nbsp;//向光标上搜索vpser字符串
- n &nbsp;&nbsp;//向下搜索前一个搜素动作
- N &nbsp;&nbsp;//向上搜索前一个搜索动作

6. 跳至指定行(vi命令模式下使用)
    - n+ &nbsp;&nbsp;//向下跳n行
    - n- &nbsp;&nbsp;//向上跳n行
    - nG &nbsp;&nbsp;//跳到行号为n的行
    - G &nbsp;&nbsp;//跳至文件的底部

7. 设置行号(vi命令模式下使用)
    - :set  nu &nbsp;&nbsp;//显示行号
    - :set nonu &nbsp;&nbsp;//取消显示行号

8. 复制、粘贴(vi命令模式下使用)
    - yy &nbsp;&nbsp;//将当前行复制到缓存区，也可以用 "ayy 复制，"a 为缓冲区，a也可以替换为a到z的任意字母，可以完成多个复制任务。
    - nyy &nbsp;&nbsp;//将当前行向下n行复制到缓冲区，也可以用 "anyy 复制，"a 为缓冲区，a也可以替换为a到z的任意字母，可以完成多个复制任务。
    - yw &nbsp;&nbsp;//复制从光标开始到词尾的字符。
    - nyw &nbsp;&nbsp;//复制从光标开始的n个单词。
    - y^ &nbsp;&nbsp;//复制从光标到行首的内容。  VPS侦探
    - y$ &nbsp;&nbsp;//复制从光标到行尾的内容。
    - p &nbsp;&nbsp;//粘贴剪切板里的内容在光标后，如果使用了前面的自定义缓冲区，建议使用"ap 进行粘贴。
    - P &nbsp;&nbsp;//粘贴剪切板里的内容在光标前，如果使用了前面的自定义缓冲区，建议使用"aP 进行粘贴。

9. 替换(vi命令模式下使用)
    - :s/old/new &nbsp;&nbsp;//用new替换行中首次出现的old
    - :s/old/new/g &nbsp;&nbsp;//用new替换行中所有的old
    - :n,m s/old/new/g &nbsp;&nbsp;//用new替换从n到m行里所有的old
    - :%s/old/new/g &nbsp;&nbsp;//用new替换当前文件里所有的old

10. 编辑其他文件
    - :e otherfilename &nbsp;&nbsp;//编辑文件名为otherfilename的文件。

11. 修改文件格式
    - :set fileformat=unix &nbsp;&nbsp;//将文件修改为unix格式，如win下面的文本文件在linux下会出现^M。

## Java

### 环境变量配置
首先我们需要解压jdk压缩包进行安装（云桌面已经配置好了），接下来我们需要进行Java环境变量的配置，在~/.profile文件下添加下列代码

```bash
export JAVA_HOME=/usr/lib/jdk1.8
export JRE_HOME=${JAVA_HOME}/jre    
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib    
export PATH=${JAVA_HOME}/bin:$PATH  
```
运行如下命令完成环境变量的配置
```bash
source ~/.profile 
source ~/.bashrc
```

### 编译运行
    
#### 编译命令

javac [-d] [-o] [-verbose] [-classpath][-sourcepath]

1. -d, 指定生成的.class文件存放目录，一般省略则默认放在java源文件同一目录下

2. -o, 这个选项告诉javac优化内联的static,final以及privite成员函数所产生的码。

3. -verbose，此选项告知java显示出有关被编译的源文件和任何被调用类库的信息。如-verbose:class能看到各种加载的信息，-verbose:gc 是garbagecollection 的信息

4. -classpath，设定要用到的类路径，可以是目录，jar文件，zip文件（里面都是class文件），值得注意的是，此classpath中的内容是会覆盖掉环境变量CLASSPATH里面的设定。也可以省略，省略则默认使用环境变量$CLASSPATH路径。所以一般classpath的设定都是：当前目录加环境变量CLASSPATH设置目录，如javac -classpath .:$CLASSPATH abc.java java基本类一般都在JDK环境变量$CLASSPATH中指定好路径了自己需要用到的第三方类一般都放在文件当前目录下，用.指定路径即可。若自己需要添加一些类可以在.:$CLASSPATH后面添加“：类的具体路径”。

5. -sourcepath， 设定要编译的java文件路径，可以是目录，jar文件，zip文件（里面都是java文件）。若编译的是jar包中的主类文件abc.java时，一般编译整个包javac edu.test.jar或者包文件夹javac ./edu/test。一般当java文件中有多个需要编译时，可以逐一列出，也可以将文件名列在一个文件中，名称间用空格或者回车行来进行分隔，然后在命令行中使用该列表名，名字前冠以@字符。

说明

- 一般对于只有一个出口主函数main，其他java文件是以内联类的形式被主函数调用的多个java文件组成的工程来说，编译时只需要对出口主函数main所在java文件编译即可，工程中的其他java文件会自动关联编译。

- 对于程序中调用到了第三方类或者package的情况，则一般先需要在程序文件中加入import第三方类或者jar包.*  如 import edu.test.abc 引用jar包edu.test下的abc.java，如果直接引用文件夹的话，则是edu/test文件夹下的abc.java文件。为稳妥，一般都引用整个包内文件import edu.test.*。（jar包名对应文件夹路径，将某个路径文件夹下的所有java文件进行打包即为jar包，引用时可以直接引用文件夹）编译时需要将jar包路径或者文件夹根目录，如edu的路径加入到classpath中。一般常把jar包或者根文件夹拷贝到当前目录下，指定classpath为.，编译器自动会从当前目录开始寻找。

#### 运行

java [-classpath] [-sourcepath]

1. -classpath和编译时一致，指定运行时要搜索的类路径。需要注意的是，由于所要执行的类也是要搜索的类的一部分，所以一定要把这个类的路径也放到classpath设置里，故在要执行的类的路径里执行java命令时，一定要加上.表示当前目录也搜索。

2. -sourcepath 指需要运行的目标文件名（不要后缀名），如编译javac a.java则运行java a。若运行的是jar包中的主类文件时需要指出包路径并要在class名前带上完整的包名，如java edu,test.abc。且该包的根目录(edu所在文件夹路径)需要包含在classpath中。

说明：

- 文件搜索时，系统只会向下，从指定目录向其子目录搜索，不会溯源向其父祖目录搜索。

- 运行时，classpath应同时包含执行的目录和调用类的目录，一般两者放在同一根目录下，运行时在根目录下运行。不然会出现错误找不到运行的main函数。如调用的类文件./com/bao/ws/h.class，执行文件为./com/bao/bs/a.class，classpath应包含.路径

## Ant
Ant是一种基于Java的打包工具，Ant脚本采用XML格式编写，默认的文件名为build.xml

### Ant中常用的节点元素

- Project: Project是项目工程的顶级节点，一个build.xml文件可以包含多个project元素节点

    Project主要属性包括：

    - Name: project节点名称
    - Default: 默认执行的target元素节点名称
    - Basedir: 项目根节点，一般为"."

- Property: Property用于定义公共常量，包含于project元素内部，以键值对形式出现

    Property主要属性包括：

    - Name: 常量名称
    - Value: 常量值
    - Location: 作用同Value，用于定义文件路径值，可以统一处理不同系统间路径符不一致问题
    
    取值方法：${name}

- Target: Target用于定义任务，包含于project元素内部，与property同级。同一个project下可包含多个target节点

    Target主要属性：

    - Name: 节点名称
    - Depends: 可选，指定target的依赖关系

- Mkdir: Mkdir用于创建路径

    Mkdir主要属性
  
    - Dir：将要被创建的路径

- Delete用于删除路径，属性Mkdir

- Copy: Copy用于复制文件

    Copy主要属性：

    - File: 源文件
    - Todir: 复制的目标路径
    - Tofile: 复制的目标文件

    子节点：FileSet

- Move用于移动文件，主要属性同Copy

- Fileset: Fileset文件集合，配合include和exclude使用。

    Fileset主要属性：

    - Dir：指定源文件路径

  

- Include: 用于描述fileset包含哪些文件

- Exclude: 用于描述fileset不包含哪些文件

- Javac

  - Javac用于编译Java源文件。
  - Javac主要属性：
  - Srcdir: 标明源文件位置
  - Destdir: 编译后文件存放位置
  - Encoding: 指定编码格式
  - Classpath: 指定lib位置
  - Debug：是否输出调试信息

- Javadoc

- Jar: Jar用于将指定文件或文件夹下内容进行打包

    Jar主要属性
    - Jarfile: 指定生产jar文件路径及名称
    - Basedir: 指定源文件位置
    - Jar的子节点manifest
    - Manifest用于指定最后生成jar包中manifest.mf文件中内容

## JUnit

### JUnit介绍
Junit是Erich Gamma 和 Kent Beck编写的测试框架，是我们在软件工程所说的白盒测试。
使用也很简单，只需要在Eclipse导入JAR包即可；

### JUnit4详解

#### Annotation

1. @Test
你要在方法的前面使用@Test 标注，以表明这是一个测试方法。对于方法的声明也有如下要求：
- 名字可以随便取，没有任何限制
- 返回值必须为 void
- 不能有任何参数

2. @After
使用了该元数据的方法在每个测试方法执行之后都要执行一次

3. @Before
使用了该元数据的方法在每个测试方法执行之前都要执行一次

4. @ignore
这个标注的含义就是―某些方法尚未完成，暂不参与此次测试。这样的话测试结果就会提示你有几个测试被忽略，而不是失败。一旦你完成了相应函数，只需要把@Ignore 标注删去，就可以进行正常的测试。

5. Fixture
任何一个测试执行之前必须执行的代码就是一个 Fixture，我们用@Before 来标注它。Fixture的含义就是在某些阶段必然被调用的代码。同理，如果在任何测试执行之后需要进行的收尾工作也是一个 Fixture，使用@After 来标注。

6. @BeforeClass 和 @AfterClass
从名字上就可以看出，用这两个 Fixture 标注的函数，只在测试用例初始化时执行@BeforeClass 方法，当所有测试执行完毕之后，执行@AfterClass 进行收尾工作。在这里要注意一下，每个测试类只能有一个方法被标注为@BeforeClass 或 @AfterClass，并且该方法必须是 Public和 Static 的。

7. assertEquals(expect, result);
判断期待结果和实际结果是否相等，第一个参数填写期待结果，第二个参数填写实际结果

#### 限时测试
一般用于死循环检测

#### 异常检测
我们需要使用@Test 标注的 expected 属性，将我们要检验的异常传递给他，这样 JUnit 框架就能自动帮我们检测是否抛出了我们指定的异常