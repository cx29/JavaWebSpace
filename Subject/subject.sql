/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : subject

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 26/06/2022 09:13:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for additional
-- ----------------------------
DROP TABLE IF EXISTS `additional`;
CREATE TABLE `additional`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `qId` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `aq___fk`(`qId`) USING BTREE,
  CONSTRAINT `aq___fk` FOREIGN KEY (`qId`) REFERENCES `question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of additional
-- ----------------------------
INSERT INTO `additional` VALUES (1, '机器语言', '汇编语言', '高级语言', '操作系统语言', '正则语言', 30);
INSERT INTO `additional` VALUES (2, '编译', ' 目标', '汇编', '解释', '\"\"', 31);
INSERT INTO `additional` VALUES (3, '实际应用程序的测试结果能够全面代表计算机的性能', '系列机的基本特性是指令系统向后兼容', '软件和硬件在逻辑功能上是等价的', '\"\"', '\"\"', 32);
INSERT INTO `additional` VALUES (4, '机器语言程序', '汇编语言程序', '硬件描述语言程序', '\"\"', '\"\"', 39);
INSERT INTO `additional` VALUES (5, '三者在数值上总是相等的', '三者在数值上可能不等', '存储字长是存放在一个存储单元中的二进制代码位数', '数据字长就是MDR的位数', '\"\"', 44);
INSERT INTO `additional` VALUES (6, '在微型计算机的广泛应用中,会计电算化属于科学计算方面的应用', '决定计算机计算精度的主要技术是计算机的字长', '计算机\"运算速度\"指标的含义是每秒能执行多少条操作系统的命令', '利用大规模集成电路技术把计算机的运算部件和控制部件做在一块集成电路芯片上,这样的一块芯片称为单片机', '\"\"', 52);
INSERT INTO `additional` VALUES (7, '提高CPU时钟频率', '优化数据通路结构', '对程序进行编译优化', '\"\"', '\"\"', 53);
INSERT INTO `additional` VALUES (8, 'ALU', '指令寄存器', '通用寄存器', '浮点寄存器', '\"\"', 59);
INSERT INTO `additional` VALUES (9, '零的表示是唯一的', '符号位可以和数值部分一起参加运算', '和其真值的对应关系简单,直观', '减法可用加法来实现', '\"\"', 86);
INSERT INTO `additional` VALUES (10, '二进制的运算规则简单', '制造两个稳态的物理器件比较容易', '便于用逻辑门电路实现算数运算', '\"\"', '\"\"', 89);

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `questionId` int(11) NOT NULL,
  `YorN` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `quesionid`(`questionId`) USING BTREE,
  CONSTRAINT `an_qu` FOREIGN KEY (`questionId`) REFERENCES `question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES (1, '存储器', 1, 1);
INSERT INTO `answer` VALUES (2, '寄存器', 1, 0);
INSERT INTO `answer` VALUES (3, '控制器', 1, 0);
INSERT INTO `answer` VALUES (4, '运算器', 1, 0);
INSERT INTO `answer` VALUES (5, '8424码', 2, 0);
INSERT INTO `answer` VALUES (6, '5421码', 2, 0);
INSERT INTO `answer` VALUES (7, '2421码', 2, 0);
INSERT INTO `answer` VALUES (8, '格雷码', 2, 1);
INSERT INTO `answer` VALUES (9, '程序', 3, 0);
INSERT INTO `answer` VALUES (10, '数据', 3, 0);
INSERT INTO `answer` VALUES (11, '微程序', 3, 0);
INSERT INTO `answer` VALUES (12, '程序和数据', 3, 1);
INSERT INTO `answer` VALUES (13, '降低整机系统的成本', 4, 0);
INSERT INTO `answer` VALUES (14, '解决CPU和主存之间的速度匹配问题', 4, 1);
INSERT INTO `answer` VALUES (15, '扩大主存容量', 4, 0);
INSERT INTO `answer` VALUES (16, '代替CPU中的寄存器工作', 4, 0);
INSERT INTO `answer` VALUES (17, '提高主存储器的存取速度', 5, 0);
INSERT INTO `answer` VALUES (18, '扩大主存储器的存储空间,并能进行自行管理和调度', 5, 1);
INSERT INTO `answer` VALUES (19, '提高外存储器的存取速度', 5, 0);
INSERT INTO `answer` VALUES (20, '扩大外存储器的存储空间', 5, 0);
INSERT INTO `answer` VALUES (21, 'ADD', 6, 1);
INSERT INTO `answer` VALUES (22, 'ADC', 6, 0);
INSERT INTO `answer` VALUES (23, 'SUB', 6, 0);
INSERT INTO `answer` VALUES (24, 'SBB', 6, 0);
INSERT INTO `answer` VALUES (25, 'SI', 7, 0);
INSERT INTO `answer` VALUES (26, 'DI', 7, 0);
INSERT INTO `answer` VALUES (27, 'CS', 7, 1);
INSERT INTO `answer` VALUES (28, 'SP', 7, 0);
INSERT INTO `answer` VALUES (29, '操作码,控制码', 8, 0);
INSERT INTO `answer` VALUES (30, '操作码,向量地址', 8, 0);
INSERT INTO `answer` VALUES (31, '操作码,地址码', 8, 1);
INSERT INTO `answer` VALUES (32, '地址码,控制码', 8, 0);
INSERT INTO `answer` VALUES (33, '16', 9, 1);
INSERT INTO `answer` VALUES (34, '17', 9, 0);
INSERT INTO `answer` VALUES (35, '18', 9, 0);
INSERT INTO `answer` VALUES (36, '15', 9, 0);
INSERT INTO `answer` VALUES (37, '延长机器周期内节拍数', 10, 0);
INSERT INTO `answer` VALUES (38, '异步', 10, 0);
INSERT INTO `answer` VALUES (39, '中央与局部控制相结合', 10, 1);
INSERT INTO `answer` VALUES (40, '同步', 10, 0);
INSERT INTO `answer` VALUES (41, 'BCD码', 11, 0);
INSERT INTO `answer` VALUES (42, '十六进制代码', 11, 0);
INSERT INTO `answer` VALUES (43, 'ASCII码', 11, 1);
INSERT INTO `answer` VALUES (44, '海明码', 11, 0);
INSERT INTO `answer` VALUES (45, '暂存器', 12, 0);
INSERT INTO `answer` VALUES (46, '栈顶和次栈顶', 12, 1);
INSERT INTO `answer` VALUES (47, '程序计数器自动+1', 12, 0);
INSERT INTO `answer` VALUES (48, '立即数', 12, 0);
INSERT INTO `answer` VALUES (49, '集中式刷新方式', 13, 0);
INSERT INTO `answer` VALUES (50, '分散式刷新方式', 13, 0);
INSERT INTO `answer` VALUES (51, '异步式刷新方式', 13, 0);
INSERT INTO `answer` VALUES (52, '同步式刷新方式', 13, 1);
INSERT INTO `answer` VALUES (53, 'RAM存储器', 14, 0);
INSERT INTO `answer` VALUES (54, 'ROM存储器', 14, 0);
INSERT INTO `answer` VALUES (55, '主存储器', 14, 0);
INSERT INTO `answer` VALUES (56, 'Cache,主存储器和外存储器', 14, 1);
INSERT INTO `answer` VALUES (57, '硬布线控制器', 15, 1);
INSERT INTO `answer` VALUES (58, '控制存储器', 15, 0);
INSERT INTO `answer` VALUES (59, '微指令寄存器', 15, 0);
INSERT INTO `answer` VALUES (60, '地址转移逻辑', 15, 0);
INSERT INTO `answer` VALUES (61, '运算器,存储器,控制器', 16, 0);
INSERT INTO `answer` VALUES (62, '外部设备和主机', 16, 0);
INSERT INTO `answer` VALUES (63, '主机和应用程序', 16, 0);
INSERT INTO `answer` VALUES (64, '配套的硬件设备和软件系统', 16, 1);
INSERT INTO `answer` VALUES (65, '控制流驱动方式', 17, 1);
INSERT INTO `answer` VALUES (66, '多指令多数据流方式', 17, 0);
INSERT INTO `answer` VALUES (67, '微程序控制方式', 17, 0);
INSERT INTO `answer` VALUES (68, '数据流驱动方式', 17, 0);
INSERT INTO `answer` VALUES (69, '多指令流单数据流', 18, 0);
INSERT INTO `answer` VALUES (70, '按地址访问并顺序执行指令', 18, 1);
INSERT INTO `answer` VALUES (71, '堆栈操作', 18, 0);
INSERT INTO `answer` VALUES (72, '存储器按内容选择地址', 18, 0);

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `subjectId` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `qs___fk`(`subjectId`) USING BTREE,
  CONSTRAINT `qs___fk` FOREIGN KEY (`subjectId`) REFERENCES `subject` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 91 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, 'CPU组成中不包含（   ）', 2);
INSERT INTO `question` VALUES (2, '下列选项中不属于有权码的是（   ）', 2);
INSERT INTO `question` VALUES (3, '内存储器用来存放（   ）', 2);
INSERT INTO `question` VALUES (4, '在主存储器和CPU之间增加Cache的主要目的是（   ）', 2);
INSERT INTO `question` VALUES (5, '采用虚拟存储器的主要目的是（   ）', 2);
INSERT INTO `question` VALUES (6, '下列属于常规加法指令的是（   ）', 2);
INSERT INTO `question` VALUES (7, '下列属于代码段寄存器的是（   ）', 2);
INSERT INTO `question` VALUES (8, '一条指令中包含的信息有（   ）', 2);
INSERT INTO `question` VALUES (9, '一个64KB的存储器，其地址线和数据线的总和是（   ）', 2);
INSERT INTO `question` VALUES (10, '计算机执行乘法指令时，由于操作较为复杂，需要更长的时间，通常采用（   ）的控制方式', 2);
INSERT INTO `question` VALUES (11, '目前在小型和微型计算机里最普遍采用的字母与字符编码是（   ）', 2);
INSERT INTO `question` VALUES (12, '零地址运算指令在指令格式中不给出操作数地址，它的操作数来自（   ）', 2);
INSERT INTO `question` VALUES (13, '下列不属于动态存储器刷新方式的选项为（    ）', 2);
INSERT INTO `question` VALUES (14, '计算机系统中的存储系统是指（   ）', 2);
INSERT INTO `question` VALUES (15, '下列选项不属于微指令控制器的组成部分的是（    ）', 2);
INSERT INTO `question` VALUES (16, '完整的计算机系统应该包括()', 2);
INSERT INTO `question` VALUES (17, '冯诺依曼机的基本工作方式是()', 2);
INSERT INTO `question` VALUES (18, '下列()是冯诺依曼机工作方式的基本特点', 2);
INSERT INTO `question` VALUES (19, '以下说法错误的是()', 2);
INSERT INTO `question` VALUES (20, '存放欲执行指令的寄存器是()', 2);
INSERT INTO `question` VALUES (21, '在CPU中,跟踪下一条要执行的指令的地址的寄存器是()', 2);
INSERT INTO `question` VALUES (22, 'CPU不包括()', 2);
INSERT INTO `question` VALUES (23, 'MAR和MDR的位数分别为()', 2);
INSERT INTO `question` VALUES (24, '在运算器中,不包含()', 2);
INSERT INTO `question` VALUES (25, '下列关于CPU存取速度的比较重,正确的是()', 2);
INSERT INTO `question` VALUES (26, '若一个8位的计算机系统以16位来表示地址,则该计算机系统有()个地址空间', 2);
INSERT INTO `question` VALUES (27, '()是程序运行时的存储位置,包括所需的数据', 2);
INSERT INTO `question` VALUES (28, '下列()属于应用软件', 2);
INSERT INTO `question` VALUES (29, '关于编译程序和解释程序,下列说法中错误的是()', 2);
INSERT INTO `question` VALUES (30, '可以在计算机中直接执行的语言和用助记符编写的语言分别是()', 2);
INSERT INTO `question` VALUES (31, '只有当程序执行时才将源程序翻译成机器语言,并且一次只能翻译一行语句,边翻译边执行的是()程序,把汇编语言源程序转变为机器语言程序的过程是()', 2);
INSERT INTO `question` VALUES (32, '下列叙述中,正确的是()', 2);
INSERT INTO `question` VALUES (33, '在CPU的组成中,不包括()', 2);
INSERT INTO `question` VALUES (34, '下列()不属于系统软件', 2);
INSERT INTO `question` VALUES (35, '关于相联存储器,下列说法中正确的是()', 2);
INSERT INTO `question` VALUES (36, '计算机系统的层次结构可以分为6层,其层次之间的依存关系是()', 2);
INSERT INTO `question` VALUES (37, '[2009,真题]冯诺依曼计算机中指令和数据均以二进制形式存放在存储器中,CPU区分它们的依据是()', 2);
INSERT INTO `question` VALUES (38, '[2016,真题]将高级语言源程序转换为机器级目标代码文件的程序是()', 2);
INSERT INTO `question` VALUES (39, '[2015,真题]计算机硬件能够直接执行的是()', 2);
INSERT INTO `question` VALUES (40, '[2019,真题]下列关于冯诺依曼计算机基本思想的叙述中,错误的是()', 2);
INSERT INTO `question` VALUES (41, '关于CPU主频,CPI,MIPS,MFLOPS,说法正确的是()', 2);
INSERT INTO `question` VALUES (42, '存储字长是指()', 2);
INSERT INTO `question` VALUES (43, '以下说法中,错误的是()', 2);
INSERT INTO `question` VALUES (44, '下列关于机器字长,指令字长和存储字长的说法中,正确的是()', 2);
INSERT INTO `question` VALUES (45, '32位微机是指该计算机所用CPU()', 2);
INSERT INTO `question` VALUES (46, '在CPU的寄存器中,()对用户来说是完全透明的', 2);
INSERT INTO `question` VALUES (47, '计算机操作的最小单位时间是()', 2);
INSERT INTO `question` VALUES (48, '计算机中,CPU的CPI与下列()因素无关', 2);
INSERT INTO `question` VALUES (49, '从用户观点看,评价计算机系统性能的综合参数是()', 2);
INSERT INTO `question` VALUES (50, '当前设计高性能计算机的重要技术途径是()', 2);
INSERT INTO `question` VALUES (51, '下列关于\"兼容\"的叙述,正确的是()', 2);
INSERT INTO `question` VALUES (52, '下列说法中,正确的是()', 2);
INSERT INTO `question` VALUES (53, '[2010]下列选项中,能缩短程序执行时间的措施是()', 2);
INSERT INTO `question` VALUES (54, '[2011]下列选项中,描述浮点数操作速度指标的是()', 2);
INSERT INTO `question` VALUES (55, '[2012]假定基准程序A在某计算机上的运行时间为100s,其中90s为CPU时间,其余为I/O时间.若CPU速度提高50%,I/O速度不变,则运行基准程序A所耗费的时间是()', 2);
INSERT INTO `question` VALUES (56, '[2013]某计算机的主频为1.2GHz,其指令分为4类,它们在基准程序中所占比例及CPI入下表所示()', 2);
INSERT INTO `question` VALUES (57, '[2014]程序P在机器M上执行时间是20s,编译优化之后,P执行的指令数减少到原来的70%,而CPI增加到原来的1.2倍,则P在M上执行时间是()', 2);
INSERT INTO `question` VALUES (58, '[2017]假定计算机M1和M2具有相同的指令集体系结构(ISA),主频分别为1.5GHz和1.2GHz.在M1和M2上运行基准程序P,平均CPI分别为2和1,则程序P在M1和M2上运行时间的比值是()', 2);
INSERT INTO `question` VALUES (59, '[2020]下列给出的部件中,其位数(宽度)一定与机器字长相同的是()', 2);
INSERT INTO `question` VALUES (60, '[2021]2017年公布全球超级计算机TOP500排名中,我国的\"神威.太湖之光\"超级计算机蝉联第一,其浮点运算速度为93.0146PFLOPS,说明该计算机每秒钟内完成浮点操作次数为约为()', 2);
INSERT INTO `question` VALUES (61, '下列各种数制的数中,最小的数是()', 2);
INSERT INTO `question` VALUES (62, '两个数7E5H和4D3H相加,得()', 2);
INSERT INTO `question` VALUES (63, '若十进制数为137.5,则其八进制数为()', 2);
INSERT INTO `question` VALUES (64, '一个16位无符号二进制数的表示范围是()', 2);
INSERT INTO `question` VALUES (65, '下列说法有误的是()', 2);
INSERT INTO `question` VALUES (66, '对真值0表示形式唯一的机器数是()', 2);
INSERT INTO `question` VALUES (67, '若[X]补=1.1101010,则[X]原=()', 2);
INSERT INTO `question` VALUES (68, '若X位负数,则由[X]补求[-X]补是将()', 2);
INSERT INTO `question` VALUES (69, '8位原码能表示的不同的数据有()个', 2);
INSERT INTO `question` VALUES (70, '一个n+1整数x原码的数值范围是()', 2);
INSERT INTO `question` VALUES (71, 'n位定点整数(有符号)表示的最大值是()', 2);
INSERT INTO `question` VALUES (72, '对于相同位数(设为N位,不考虑符号位)的二进制补码小数和十进制小数,二进制小数能表示的数的个数/十进制小数所能表示数的个数为()', 2);
INSERT INTO `question` VALUES (73, '若定点整数为64位,含1位符号位,则采用补码表示的绝对值的最大的负数为()', 2);
INSERT INTO `question` VALUES (74, '下列关于补码和移码关系的叙述中,()是不正确的', 2);
INSERT INTO `question` VALUES (75, '若[X]补=1,X1X2X3X4X5X6,其中Xi取0或1,若要X>-32,应当满足()', 2);
INSERT INTO `question` VALUES (76, '设X为整数,[X]补=1,X1X2X3X4X5,若要X<-16,X1~X5应满足的条件是()', 2);
INSERT INTO `question` VALUES (77, '设X为真值,X*为其绝对值,满足[-X*]补=[-X]补,当且仅当()', 2);
INSERT INTO `question` VALUES (78, '假定一个十进制数为-66,按补码形式存放在一个8位寄存器中,则该寄存器的内容用十六进制表示位()', 2);
INSERT INTO `question` VALUES (79, '设机器数采用补码表示(含1位符号位),若寄存器内容为9BH,则对应的十进制数为()', 2);
INSERT INTO `question` VALUES (80, '若寄存器内容为10000000,若它等于-0,则为()', 2);
INSERT INTO `question` VALUES (81, '若寄存器内容为11111111,若它等于+127,则为()', 2);
INSERT INTO `question` VALUES (82, '若寄存器内容为11111111,若它等于-1,则为()', 2);
INSERT INTO `question` VALUES (83, '若寄存器内容为00000000,若它等于-128,则为()', 2);
INSERT INTO `question` VALUES (84, '若二进制定点小数真值为-0.1101,机器表示为1.0010,则为()', 2);
INSERT INTO `question` VALUES (85, '下列为8位移码机器数[X]移,求[-X]移时,()将会发生溢出', 2);
INSERT INTO `question` VALUES (86, '计算机内部的定点大多用补码表示,以下是一些关于补码特点的叙述,其中正确的是()', 2);
INSERT INTO `question` VALUES (87, '在计算机中,通常用来表示主存地址的是()', 2);
INSERT INTO `question` VALUES (88, '[2015]由3个\"1\"和5个\"0\"组成的8位二进制补码,能表示的最小整数是()', 2);
INSERT INTO `question` VALUES (89, '[2018]冯诺依曼结构计算机中的数据采用二进制编码表示,其主要原因是()', 2);
INSERT INTO `question` VALUES (90, '[2021]已知带符号整数用补码表示,变量X,Y,Z的机器数分别位FFFDH,FFDFH,7FFCH,下列结论中,正确的是()', 2);

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `subject_id_uindex`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES (1, '数据结构');
INSERT INTO `subject` VALUES (2, '计算机组成原理');
INSERT INTO `subject` VALUES (3, '操作系统');
INSERT INTO `subject` VALUES (4, '计算机网络');

SET FOREIGN_KEY_CHECKS = 1;
