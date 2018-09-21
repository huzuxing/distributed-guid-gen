# distributed-guid-gen
分布式系统高性能ID生成器，Java版

原理：雪花算法

long 类型，高位为0，40位时间戳（毫秒），10位机器ID，12位序列号

支持2^10-1=1023台机器，同一毫秒最大峰值，2^12-1=4095个ID产生

支持ID反解，通过ID可以知道ID是什么时候，由哪台机器产生。

机器ID供应方：
1、配置文件
2、ip
3、DB
4、zookeeper

说明：
当同一毫秒，序列号用完后，必须等下一毫秒产生
