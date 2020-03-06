# 比赛项目管理模块

## 安装依赖
- 配置MySQL用户名和密码

- 运行flyway脚本生成表
```sql
mvn flyway:migrate
```
- 运行mybatis脚本
```sql
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```
请放心执行这条命令，覆盖掉原有文件不会对功能造成任何影响，有影响部分均已做了处理。
