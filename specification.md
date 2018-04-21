# 开发文档

目的：根据艾宾浩斯记忆曲线给出当前时间需要复习的科目。<br>
语言：java<br>
模式：MVC、C/S（只在服务器端验证身份，不进行云存储）<br>





## 客户端

####  其他文件

Data.xml        保存序列化对象<br>
Config.conf      配置文件，保存Data id等关键数据<br>

### .Control
AddMission  增加任务
* 功能：对用户发来的增加任务操作进行响应<br>
* 传参：Data<br>
* 返回：null<br>

AllMission  所有的任务信息
* 功能：返回所有的任务信息，需要重排序<br>
* 传参：null<br>
* 返回：HashSet<br>

ClosePro    关闭程序(继承WindowAdapter)
* 功能：关闭程序前对资源的整理以及保存<br>
* 传参：null<br>
* 返回：null<br>

EditMission 编辑任务
* 功能：响应用户的编辑操作<br>
* 传参：Data<br>
* 返回：null<br>

FinishMission   完成任务
* 功能：响应用户的完成操作<br>
* 传参：Data<br>
* 返回：null<br>

QueryMission    查询任务
* 功能：根据任务id查询任务信息<br>
* 传参：String<br>
* 返回：Data<br>

RemoveMission   删除任务
* 功能：响应用户的删除操作<br>
* 传参：Data<br>
* 返回：null<br>

SetToArray      Set转数组
* 功能：set集合转换为二维数组，在界面显示表格时需要使用<br>
* 传参：HashSet<br>
* 返回：Object[][]<br>

StartPro        程序开始
* 功能：对程序运行需要的资源进行初始化<br>
* 传参：null<br>
* 返回：null<br>

TimeControl     时间控制（实现Runnable）
* 功能：修改主界面时间<br>
* 传参：null<br>
* 返回：null<br>

### .Data

#### 使用类封装进度

Data(序列化)

    int    id           //编号
    String mainName     //主名字
    String indexName    //副名字
    Date   nextTime     //下次提醒时间
    int    state        //当前进度所处状态
    boolean finish      //标记完成
>复写equals

Config      配置文件（单例）
    
    int id              //编号

DataBuffer      数据缓存区域，将程序可能会用到的数据进行缓存（单例）

    HashSet<Data> allData   //保存所有数据
    HashSet<Data> screenData    //保存扫描过的数据

### .Handle

#### .HandleConfig (配置文件)

ReadConfig      读取配置文件<br>
* 功能：直接对单例Config进行更改&赋值<br>
* 传参：null<br>
* 返回：null<br>

SaveConfig      保存配置文件<br>
* 功能：保存配置信息到文件中<br>
* 传参：Map集合，需要保存的配置参数组成的map集合<br>
* 返回：null<br>

####  .HandleCPUNumber  (发送机器的CPU序列号到服务器进行校验)

GetNumber       获取机器的CPU序列号并返回<br>
* 功能：获取机器的CPU序列号<br>
* 传参：null<br>
* 返回：String<br>

SendNumber      发送机器的序列号进行服务器验证，返回验证结果<br>
* 功能：向服务器验证权限<br>
* 传参：String<br>
* 返回：Boolean<br>

#### .HandleData    (对数据进行存取筛选)

DataScreen      筛选需要复习的数据并返回<br>
* 目的：筛选未完成的任务到screenData中<br>
* 传参：null<br>
* 返回：null<br>

InitData        从文件中初始化对象数组并返回<br>
* 目的：将文件中的对象取出并保存到DataBuffer中<br>
* 传参：null<br>
* 返回：null<br>

SaveData        对保存序列化的对象数组<br>
* 目的：将DataBuffer中的数据进行合并并保存到文件中<br>
* 传参：null<br>
* 返回：null<br>

#### .UserOperate(响应用户操作，完成，修改等)

EditData        编辑任务<br>
* 目的：编辑&修改指定任务（key=id）<br>
* 传参：Data<br>
* 返回：null<br>

FinishData      完成任务<br>
* 目的：分配下一次任务时间（使用EditData编辑状态）<br>
* 传参：Data<br>
* 返回：Data<br>

RemoveData      移除任务<br>
* 目的：移除任务（key=id）<br>
* 传参：Data<br>
* 返回：null<br>

#### OtherTools

ButtonEditor    编辑按钮
* 目的：新建按钮使得可以加到JTable中<br>
* 传参：null<br>
* 返回：null<br>

TableButton     编辑按钮
* 目的：新建按钮使得可以加到JTable中<br>
* 传参：null<br>
* 返回：null<br>

### .View   （图形化界面）

MainFrame       主页面，负责显示复习复习内容以及其他跳转按钮<br>
AddFrame        增加Data页面<br>
EditFrame       对Data进行编辑<br>
QueryFrame      对Data进行查询<br>


