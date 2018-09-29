
* [数据源管理](####数据源管理)
   * [列表查询](#####列表查询)
   * [数据源新增](#####数据源新增)
   * [数据源更新](#####数据源更新)
   * [数据源删除](#####数据源删除)
   * [数据源删除前判断](#####数据源删除前判断)
   * [数据源下拉列表](#####数据源下拉列表)
   * [字段下拉列表](#####字段下拉列表)
   * [指标下拉列表](#####指标下拉列表)
* [指标管理](####指标管理)
   * [1.新增指标](#####1新增指标)
   * [2.修改指标](#####2修改指标)
   * [3.获取表头](#####3获取表头)
   * [4.获取指定Id的指标详情](#####4获取指定id的指标详情)
   * [5.删除检查（检查指标能不能被删除）](#####5删除检查检查指标能不能被删除)
   * [6.重复校验](#####6重复校验)
   * [7.分页查询](#7#####分页查询)
   * [8.指标总览统计](#8指标总览统计)
   * [9.删除](#####9删除)
* [字段管理](####字段管理)
   * [1.新增字段](#1#####新增字段)
   * [2.修改字段](#2#####修改字段)
   * [3.name、code重复校验](#3#####namecode重复校验)
   * [4.获取表头](#####4获取表头)
   * [5.获取字段详情](#####5获取字段详情)
   * [6.分页列表](#####6分页列表)
   * [7.删除字段](#####7删除字段)
   * [8.字段复制](#####8字段复制)
   * [9.删除检查](#####9删除检查)
* [计算方式管理](####计算方式管理)
   * [1.新增自定义计算方式](#####1新增自定义计算方式)
   * [2.修改自定义计算方式](#####2修改自定义计算方式)
   * [3.删除自定义计算方式](#####3删除自定义计算方式)
   * [4.计算类型下拉菜单](#####4计算类型下拉菜单)
   * [5.计算方式分页列表](#####5计算方式分页列表)
   * [6.获取计算方式详情](#####6获取计算方式详情)
   * [7.name、code重复校验](#####7namecode重复校验)
   * [8.上传文件](#####8上传文件)




#### 数据源管理

##### 列表查询

URL `ic/dataSource/getPageInfoList`

请求方法 `GET` 

| 参数名称   | 类型   | 含义     | 是否必填 |
| ---------- | ------ | -------- | -------- |
| sourceType | 字符串 | 数据源   | 否       |
| source     | 整型   | 来源     | 否       |
| cmUser     | 字符串 | 操作人员 | 否       |


返回结果
```json
{
  "data": {
    "itemCount": 0,
    "items": [
      
    ],
    "pageCount": 0,
    "pageNo": 1,
    "pageSize": 10
  },
  "success": true
}
```

```json
{
  "data": {
    "itemCount": 1,
    "items": [
      {
        "cmUser": "admin/admin",
        "code": "hello_dataSource",
        "createUserId": 1,
        "dataType": 1,
        "dataTypeDesc": "实时数据",
        "id": 3,
        "modifyTime": "2018-09-27 13:24:44",
        "modifyUserId": 1,
        "name": "数据源新增1",
        "sourceType": 1,
        "sourceTypeDesc": "风控系统"
      }
    ],
    "pageCount": 1,
    "pageNo": 1,
    "pageSize": 10
  },
  "success": true
}
```

##### 数据源新增

URL `ic/dataSource/add`

请求方法 `POST` 

| 参数名称 | 类型   | 含义       | 是否必填 |
| -------- | ------ | ---------- | -------- |
| name     | 字符串 | 数据源名称 | 是       |
| code     | 字符串 | 数据源code | 是       |
| script   | 字符串 | 预处理脚本 | 是       |

返回结果
```json
{
    "msg": "数据源code重复",
    "success": false
}
```

```json
{
    "data": "新增数据源成功",
    "success": true
}
```

##### 数据源更新

`ic/dataSource/update`

请求方法 `POST` 

| 参数名称 | 类型   | 含义       | 是否必填 |
| -------- | ------ | ---------- | -------- |
| name     | 字符串 | 数据源名称 | 是       |
| script   | 字符串 | 预处理脚本 | 是       |

##### 数据源删除

URL `ic/dataSource/delete`

请求方法 `POST` 

| 参数名称     | 类型 | 含义     | 是否必填 |
| ------------ | ---- | -------- | -------- |
| dataSourceId | 整型 | 数据源id | 是       |


##### 数据源删除前判断

URL `ic/dataSource/delete/check`

请求方法 `POST` 

| 参数名称     | 类型 | 含义     | 是否必填 |
| ------------ | ---- | -------- | -------- |
| dataSourceId | 整型 | 数据源id | 是       |

##### 数据源下拉列表

URL `ic/dataSource/dataSourceList`

请求方法 `GET` 

```json
{
  "success": true,
  "data": [
    {
      "code": null,
      "name": "数据源新增1",
      "id": 3,
      "departmentId": null
    },
    {
      "code": null,
      "name": "数据源新增2",
      "id": 6,
      "departmentId": null
    }
  ],
  "msg": null
}
```

##### 字段下拉列表

URL '/ic/field/fieldList'

请求方法 `GET` 

| 参数名称 | 类型 | 含义     | 是否必填                                 |
| -------- | ---- | -------- | ---------------------------------------- |
| appId    | Long | 应用id   | 否                                       |
| eventId  | Long | 事件id   | 否                                       |
| sourceId | Long | 事件源id | 否(如果事件源id没有传，应用和事件id必传) |

```json
{
  "data": [],
  "success": true
}
```

##### 指标下拉列表

URL '/ic/indicator/icIndicatorList'

请求方法 `GET`

| 参数名称 | 类型 | 含义     | 是否必填                                 |
| -------- | ---- | -------- | ---------------------------------------- |
| appId    | Long | 应用id   | 否                                       |
| eventId  | Long | 事件id   | 否                                       |
| sourceId | Long | 事件源id | 否(如果事件源id没有传，应用和事件id必传) |

```json
{
  "data": [],
  "success": true
}
```

#### 指标管理

##### 1.新增指标

**Request**

- Method : POST

- URI : /ic/indicator/insert
- Body

| 字段名                              | 类型   | 是否必须 | 说明                                                         | 例子    |
| :---------------------------------- | ------ | -------- | ------------------------------------------------------------ | ------- |
| name                                | String | 是       | 指标名                                                       | 省略...|
| description                         | String | 否       | 描述                                                         | 省略...|
| dataSourceId                        | long   | 是       | 数据源id                                                     |         |
| windowSize                          | int    | 是       | 滑动窗口总长度                                               |         |
| windowTimeUnit                      | int    | 是       | 窗口时间单位：1秒，2分钟，3小时，4天，5月，6自然日，7自然周，8自然月，9自然年 |         |
| slideSize                           | int    | 否       | 时间精度                                                     |         |
| slideTimeUnit                       | int    | 否       | 时间精度：1秒，2分钟，3小时，4天，5月，6自然日，7自然周，8自然月，9自然年 |         |
| firstField                          | string | 是       | 主属性                                                       |         |
| secondField                         | string | 否       | 从属性                                                       |         |
| computeField                        | string | 是       | 计算字段                                                     |         |
| computeType                         | int    | 是       | 计算类型                                                     |         |
| sourceType                          | int    | 是       | 指标来源类型，1:风控指标，2自定义指标                        |         |
| includeType                         | int    | 是       | 请求是否计算，0-不计算本次，1-计算本次，4不计算当天，默认0   |         |
| indicatorRuleList[0].logicOperator  | int    | 否       | 指标规则表达式右侧的逻辑操作符，可为空（右侧没有更多的规则表达式） ,1 逻辑或（\|\|)2逻辑与（&&) |         |
| indicatorRuleList[0].leftField      | string | 是       | 左变量code                                                   |         |
| indicatorRuleList[0].leftFieldName  | string | 是       | 左变量名称                                                   |         |
| indicatorRuleList[0].leftFieldType  | int    | 是       | 左变量类型                                                   |         |
| indicatorRuleList[0].rightField     | string | 是       | 右变量                                                       |         |
| indicatorRuleList[0].rightFieldName | string | 是       | 右变量名称                                                   |         |
| indicatorRuleList[0].rightFieldType | int    | 是       | 右变量类型                                                   |         |
| indicatorRuleList[0].operator       | string | 是       | 操作符枚举：">"，"<"，"==","!=",">=","<=","isNull"，"isEmpty","Up"趋势自增,"Down"趋势递减,"Horizontal"趋势水平 |         |
| indicatorRuleList[0].type           | int    | 是       | 操作符（operator）类型:1比较，2内置函数 (isNull、isEmpty)，3趋势（Up、Down、Horizontal） |         |

**  说明**：indicatorRuleList代表一个规则数组，前端通过指定下标的形式来传递参数。

**Response**

- Content-Type : `application/json`
- Body : 

1.正常成功请求：

```json

{
    "success": true,
    "data": "添加成功",
    "msg": null
}
```

2.完全一样的两个指标(规则、计算方式、时间窗口一样)：

```json

{
    "success": true,
    "data": "已存在语义一致的指标",
    "msg": null
}

```







-----------------------------------------------------------
##### 2.修改指标

**Request**

- Method : POST

- URI : /ic/indicator/update
- Body

| 字段名                              | 类型   | 是否必须 | 说明                                                         | 例子    |
| :---------------------------------- | ------ | -------- | ------------------------------------------------------------ | ------- |
| id                                  | long   | 是       | 指标Id                                                       |         |
| name                                | String | 是       | 指标名                                                       | 省略...|
| description                         | String | 否       | 描述                                                         | 省略...|
| dataSourceId                        | long   | 是       | 数据源id                                                     |         |
| windowSize                          | int    | 是       | 滑动窗口总长度                                               |         |
| windowTimeUnit                      | int    | 是       | 窗口时间单位：1秒，2分钟，3小时，4天，5月，6自然日，7自然周，8自然月，9自然年 |         |
| slideSize                           | int    | 否       | 时间精度                                                     |         |
| slideTimeUnit                       | int    | 否       | 时间精度：1秒，2分钟，3小时，4天，5月，6自然日，7自然周，8自然月，9自然年 |         |
| firstField                          | string | 是       | 主属性                                                       |         |
| secondField                         | string | 否       | 从属性                                                       |         |
| computeField                        | string | 是       | 计算字段                                                     |         |
| computeType                         | int    | 是       | 计算类型                                                     |         |
| status                              | int    | 是       | 状态：1启用，0未启用                                         |         |
| includeType                         | int    | 是       | 请求是否计算，0不计算本次，1计算本次，4不计算当前自然日，默认0 |         |
| indicatorRuleList[0].logicOperator  | int    | 否       | 指标规则表达式右侧的逻辑操作符，可为空（右侧没有更多的规则表达式） ,1 逻辑或（\|\|)2逻辑与（&&) |         |
| indicatorRuleList[0].leftField      | string | 是       | 左变量code                                                   |         |
| indicatorRuleList[0].leftFieldName  | string | 是       | 左变量名称                                                   |         |
| indicatorRuleList[0].leftFieldType  | int    | 是       | 左变量类型                                                   |         |
| indicatorRuleList[0].rightField     | string | 是       | 右变量                                                       |         |
| indicatorRuleList[0].rightFieldName | string | 是       | 右变量名称                                                   |         |
| indicatorRuleList[0].rightFieldType | int    | 是       | 右变量类型                                                   |         |
| indicatorRuleList[0].operator       | string | 是       | 操作符枚举：">"，"<"，"==","!=",">=","<=","isNull"，"isEmpty","Up"趋势自增,"Down"趋势递减,"Horizontal"趋势水平 |         |
| indicatorRuleList[0].type           | int    | 是       | 操作符（operator）类型:1比较，2内置函数 (isNull、isEmpty)，3趋势（Up、Down、Horizontal） |         |

**  说明**：indicatorRuleList代表一个规则数组，前端通过指定下标的形式来传递参数。

**Response**

- Content-Type : `application/json`
- Body : 

1.正常成功请求：

```json

{
    "success": true,
    "data": "修改成功",
    "msg": null
}
```

2.完全一样的两个指标(规则、计算方式、时间窗口一样)：

```json

{
    "success": true,
    "data": "已存在语义一致的指标",
    "msg": null
}
```



-----------------------------------------------------------

##### 3.获取表头

**Request**

- Method :  GET
- URI : /ic/indicator/tableHeader
- Body

**Response**

- Content-Type : `application/json`
- Body : 

1.正常成功请求：

```json
{
    "success": true,
    "data": {
        "code": "指标code",
        "create_time": "创建时间",
        "modify_user": "修改人",
        "modify_time": "修改时间",
        "name": "名称",
        "data_source_name": "数据源",
        "source_type": "来源",
        "id": "ID",
        "create_user": "创建人",
        "cited_times": "被使用次数",
        "status": "指标状态"
    },
    "msg": null
}
```



--------------------------------------------------



##### 4.获取指定Id的指标详情

**Request**

- Method : GET

- URI : /ic/indicator/${indicatorId}
- Body : 



**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": true,
    "data": {
        "id": 15,
        "name": "aaaa",
        "code": "2_register_event-aaa-bdd-4s-1s-count-ccc-36583722001",
        "description": "aaa",
        "dataSourceId": 1,
        "slideSize": 1,
        "slideTimeUnit": 1,
        "windowSize": 4,
        "windowTimeUnit": 1,
        "firstField": "aaa",
        "secondField": "bdd",
        "computeField": "ccc",
        "computeType": 1,
        "includeType": 1,
        "templateType": 0,
        "status": 0,
        "sourceType": 2
    },
    "msg": null
}
```



------

##### 5.删除检查（检查指标能不能被删除）

**Request**

- Method : GET

- URI : /ic/indicator/delete/check
- Body : 

| 字段名 | 类型 | 是否必须 | 说明   | 例子 |
| ------ | ---- | -------- | ------ | ---- |
| id     | long | 是       | 指标ID |      |

**Response**

- Content-Type : `application/json`
- Body 

1.正常请求

```json
{
    "success": true,
    "data": null,
    "msg": null
}
```

2.非正常请求

```json
{
    "success": true,
    "data": [
        1 //策略id（代表指标被这个策略引用）
    ],
    "msg": null
}
```



------------------

##### 6.重复校验

**Request**

- Method : GET

- URI : /ic/indicator/checkDuplicate
- Body : 

| 字段名       | 类型   | 是否必须 | 说明     | 例子 |
| ------------ | ------ | -------- | -------- | ---- |
| name         | string | 是       | 指标name |      |
| dataSourceId | long   | 是       | 数据源Id |      |

**Response**

- Content-Type : `application/json`
- Body 

1.重复

```json
{
    "success": false,
    "data": null,
    "msg": "该数据源下已有同名的指标[15]"
}
```

2.不重复

```json
{
    "success": true,
    "data": null,
    "msg": null
}
```



------

##### 7.分页查询

**Request**

- Method : GET

- URI : /ic/indicator/list
- Body : 

| 字段名       | 类型   | 是否必须 | 说明     | 例子 |
| ------------ | ------ | -------- | -------- | ---- |
| nameOrId     | string | fou      | 查询字段 |      |
| dataSourceId | long   | 否       | 数据源ID |      |
| status       | int    | 否       | 指标状态 |      |
| appId        | long   | 否       | 应用Id   |      |
| eventId      | long   | 否       | 事件Id   |      |

**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": true,
    "data": {
        "indicatorStatusStats": {
            "all": 1,
            "disable": 1,
            "enable": 0
        },
        "page": {
            "callback": null,
            "scriptWrapping": null,
            "pageNo": 1,
            "pageSize": 10,
            "itemCount": 1,
            "pageCount": null,
            "startOffset": 0,
            "items": [
                {
                    "id": 15,
                    "name": "aaaa",
                    "dataSourceId": 1,
                    "templateType": 0,
                    "status": 0,
                    "sourceType": 1,
                    "citedTimes": 0,
                    "createTime": "2018-09-27 16:21:07.0",
                    "modifyTime": "2018-09-28 14:01:27.0",
                    "createUserId": 1,
                    "modifyUserId": 1,
                    "cmUser": "管理员/管理员",
                    "dataSourceName": ""
                }
            ],
            "needQueryCount": false
        }
    },
    "msg": null
}
```





--------

##### 8.指标总览统计

**Request**

- Method : GET

- URI : /ic/dashboard/overviewStats
- Body : 

| 字段名       | 类型   | 是否必须 | 说明                          | 例子 |
| ------------ | ------ | -------- | ----------------------------- | ---- |
| startTime    | string | 否       | 查询字段                      |      |
| dataSourceId | long   | 否       | 数据源ID                      |      |
| endTime      | string | 否       | 结束时间                      |      |
| sourceType   | int    | 是       | 风控查询1，自定义数据源查询2  |      |
| appId        | long   | 否       | 风控系统里面会使用到的appId,  |      |
| eventId      | long   | 否       | 风控系统里面会使用到的eventId |      |

**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": true,
    "data": {
        "readInvokeStats": 0, //指标读接口调用统计
        "writeInvokeStats": 0//指标计算接口调用统计
    },
    "msg": null
}
```



##### 9.删除

**Request**

- Method : POST
- URI : /ic/indicator/delete
- Body : 

| 字段名 | 类型 | 是否必须 | 说明   | 例子 |
| ------ | ---- | -------- | ------ | ---- |
| id     | long | 是       | 指标id |      |

**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": true,
    "data": "删除成功",
    "msg": null
}
```



#### 字段管理

##### 1.新增字段

**Request**

- Method : POST
- URI : /ic/field/add
- Body

| 字段名       | 类型   | 是否必须 | 说明         | 例子 |
| ------------ | ------ | -------- | ------------ | ---- |
| name         | string | 是       | 查询字段     |      |
| dataSourceId | long   | 是       | 数据源ID     |      |
| code         | string | 是       | 结束时间     |      |
| dataType     | int    | 是       | 字段数据类型 |      |
| maxLength    | int    | 是       | 最大长度     |      |
| description  | string | 否       | 描述         |      |

**Response**

- Content-Type : `application/json`
- Body 

1.正常请求

```json
{
    "success": true,
    "data": "添加成功",
    "msg": null
}
```

2.异常请求

```
{
    "success": true,
    "data": "该数据源存在同name或同code字段，添加失败",
    "msg": null
}
```





----------

##### 2.修改字段

**Request**

- Method : POST
- URI : /ic/field/update
- Body

| 字段名       | 类型   | 是否必须 | 说明         | 例子 |
| ------------ | ------ | -------- | ------------ | ---- |
| name         | string | 是       | 查询字段     |      |
| dataSourceId | long   | 是       | 数据源ID     |      |
| code         | string | 是       | 结束时间     |      |
| dataType     | int    | 是       | 字段数据类型 |      |
| maxLength    | int    | 是       | 最大长度     |      |
| description  | string | 否       | 描述         |      |
| status       | int    | 是       | 字段状态     |      |
| id           | long   | 是       | 字段ID       |      |

**Response**

- Content-Type : `application/json`
- Body 

1.正常请求

```json
{
    "success": true,
    "data": "修改成功",
    "msg": null
}
```

2.异常请求

```
{
    "success": true,
    "data": "该数据源存在同name或同code字段，修改失败",
    "msg": null
}
```



--------------------------------------------------------------------

##### 3.name、code重复校验

**Request**

- Method :  GET
- URI : /ic/field/checkDuplicate
- Body

| 字段名       | 类型   | 是否必须 | 说明     | 例子 |
| ------------ | ------ | -------- | -------- | ---- |
| dataSourceId | long   | 是       | 数据源Id |      |
| name         | string | 否       | 字段name |      |
| code         | string | 否       | 字段code |      |

**Response**

- Content-Type : `application/json`
- Body 

1.不重复

```json
{
    "success": true,
    "data": null,
    "msg": null
}
```

2.重复

``` json
{
    "success": true,
    "data": [
        8//重复Id
    ],
    "msg": "该数据源下已存在同name或code字段"
}
```



##### 4.获取表头

**Request**

- Method :  GET
- URI : /ic/field/tableHeader
- Body

**Response**

- Content-Type : `application/json`
- Body : 

1.正常成功请求：

```json
{
    "success": true,
    "data": {
        "modifyUser": "修改人",
        "fieldName": "字段名",
        "modifyTime": "最后修改时间",
        "fieldCode": "字段Code",
        "dataType": "数据类型",
        "fieldDescription": "描述",
        "createUser": "创建人",
        "dataSourceName": "数据源名",
        "maxLength": "最大长度",
        "fieldId": "字段Id"
    },
    "msg": null
}
```



-------------------------------------------------------

##### 5.获取字段详情

**Request**

- Method : GET
- URI : /ic/field/${fieldId}
- Body : 



**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": true,
    "data": {
        "id": 8,
        "dataSourceId": 1,
        "name": "test111aa",
        "code": "test111",
        "dataType": 1,
        "maxLength": 3,
        "description": "hhh",
        "status": 0,
        "sourceType": 2
    },
    "msg": null
}
```





-----------------------------------------------------------

##### 6.分页列表

**Request**

- Method : GET
- URI : /ic/field/list
- Body : 

| 字段名       | 类型   | 是否必须 | 说明     | 例子 |
| ------------ | ------ | -------- | -------- | ---- |
| dataSourceId | long   | 否       | 数据源Id |      |
| query        | string | 否       | 查询字段 |      |

**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": true,
    "data": {
        "callback": null,
        "scriptWrapping": null,
        "pageNo": 1,
        "pageSize": 10,
        "itemCount": 3,
        "pageCount": null,
        "startOffset": 0,
        "items": [
            {
                "fieldName": "王浩测试字段",
                "fieldCode": "ext_wh",
                "dataSourceName": "",
                "dataType": 1,
                "maxLength": 64,
                "fieldDescription": null,
                "createUserName": "admin",
                "modifyUserName": "admin",
                "modifyTime": "2018-09-26 11:22:38.0",
                "fieldId": 1,
                "dataSourceId": 1
            },
            {
                "fieldName": "test",
                "fieldCode": "test",
                "dataSourceName": "",
                "dataType": 1,
                "maxLength": 3,
                "fieldDescription": null,
                "createUserName": "admin",
                "modifyUserName": "admin",
                "modifyTime": "2018-09-27 19:43:29.0",
                "fieldId": 4,
                "dataSourceId": 1
            },
            {
                "fieldName": "test111aa",
                "fieldCode": "test111",
                "dataSourceName": "",
                "dataType": 1,
                "maxLength": 3,
                "fieldDescription": null,
                "createUserName": "admin",
                "modifyUserName": "admin",
                "modifyTime": "2018-09-27 19:55:58.0",
                "fieldId": 8,
                "dataSourceId": 1
            }
        ],
        "needQueryCount": false
    },
    "msg": null
}
```



--------------------------------------------------------

##### 7.删除字段

**Request**

- Method : POST
- URI : /ic/field/delete
- Body : 

| 字段名 | 类型 | 是否必须 | 说明     | 例子 |
| ------ | ---- | -------- | -------- | ---- |
| id     | long | 是       | 数据源Id |      |

**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": true,
    "data": "删除成功",
    "msg": null
}
```



----------

##### 8.字段复制

**Request**

- Method : POST
- URI : /ic/field/copy
- Body : 

| 字段名       | 类型       | 是否必须 | 说明               | 例子 |
| ------------ | ---------- | -------- | ------------------ | ---- |
| dataSourceId | long       | 是       | 数据源Id           |      |
| idList       | long array | 是       | 被复制的字段Id数组 |      |

**Response**

- Content-Type : `application/json`
- Body 

1.正常请求

```json
{
    "success": true,
    "data": "1个字段复制成功",
    "msg": null
}
```

2.异常请求

```json
{
    "success": false,
    "data": null,
    "msg": "该数据源下已存在同name或code字段，复制失败"
}

{
    "success": false,
    "data": null,
    "msg": "选中的字段已被其他用户删除,复制失败"
}
```



-----------------------------------

##### 9.复制校验

___________

**Request**

- Method : GET
- URI :  /ic/field/copyCheck
- Body : 

| 字段名 | 类型   | 是否必须 | 说明             | 例子 |
| ------ | ------ | -------- | ---------------- | ---- |
| ids    | string | 是       | 字段id用逗号分隔 |      |

**Response**

- Content-Type : `application/json`
- Body 

1.存在同name、code字段

```json
{
    "success": false,
    "data": null,
    "msg": "存在同name或者code字段"
}

```

2.不存在同name、code字段

```json 

{
    "success": true,
    "data": null,
    "msg": null
}
```



##### 10.删除检查

**Request**

- Method : GET
- URI : /ic/field/ delete/check
- Body : 

| 字段名 | 类型 | 是否必须 | 说明   | 例子 |
| ------ | ---- | -------- | ------ | ---- |
| id     | long | 是       | 字段Id |      |

**Response**

- Content-Type : `application/json`
- Body 

1.可以删除

```json
{
    "success": true,
    "data": null,
    "msg": null
}
```

2.不可删除

```json
{
    "success": true,
    "data": [
        15//指标ID
    ],
    "msg": "字段被指标引用"
}
```



___________

##### 11.批量插入

**Request**

- Method : POST
- URI : /ic/field/add/batch
- Body : 

| 字段名        | 类型 | 是否必须 | 说明     | 例子 |
| ------------- | ---- | -------- | -------- | ---- |
| dataSourceId  | long | 是       | 数据源id |      |
| fieldList[0].name | string | 是       | 查询字段     |      |
| fieldList[0].code | string | 是       | 结束时间     |      |
| fieldList[0].dataType | int    | 是       | 字段数据类型 |      |
| fieldList[0].maxLength | int    | 是       | 最大长度     |      |
| fieldList[0].description | string | 否       | 描述         |      |

**Response**

- Content-Type : `application/json`
- Body 

```json

```

#### 计算方式管理

___________
##### 1.新增自定义计算方式

**Request**

- Method : POST
- URI : /ic/computeType/add
- Body : 

| 字段名          | 类型   | 是否必须 | 说明                                | 例子 |
| --------------- | ------ | -------- | ----------------------------------- | ---- |
| name            | string | 是       | name                                | ---- |
| code            | string | 是       | code                                |      |
| script          | string | 是       | 处理脚本                            |      |
| description     | string | 否       | 描述                                |      |
| fileIds         | string | 是       | 文件id字符串逗号分隔                | 1,2  |
| supportDataType | string | 是       | 支持的数据类型,不同数据类型逗号分隔 | 1,2  |

**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": true,
    "data": "添加成功",
    "msg": null
}
```



##### 2.修改自定义计算方式

___________
**Request**

- Method : POST
- URI : /ic/computeType/update
- Body : 

| 字段名 | 类型   | 是否必须 | 说明 | 例子 |
| ------ | ------ | -------- | ---- | ---- |
| name        | string | 是       | name                 | ---- |
| code        | string | 是       | code                 |      |
| script      | string | 是       | 处理脚本             |      |
| description | string | 否       | 描述                 |      |
| fileIds     | string | 是       | 文件id字符串逗号分隔 | 1,2  |
| id | long | 是 | ID |  |
| status | int | 是 | 1启用、0未启用 |  |
| supportDataType | string | 是 | 支持的数据类型,不同数据类型逗号分隔 | 1,2 |

**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": true,
    "data": "修改成功",
    "msg": null
}
```



##### 3.删除自定义计算方式

___________
**Request**

- Method : POST
- URI : /ic/computeType/delete
- Body : 

| 字段名 | 类型 | 是否必须 | 说明       | 例子 |
| ------ | ---- | -------- | ---------- | ---- |
| id     | long | 是       | 计算方式ID | ---- |

**Response**

- Content-Type : `application/json`
- Body 

1.删除成功

```json
{
    "success": true,
    "data": "删除成功",
    "msg": null
}
```

2.删除失败

```json
{
    "success": false,
    "data": null,
    "msg": "系统内置计算方式无法删除"
}
/////////////////////////
{
    "success": false,
    "data": null,
    "msg": "不能删除系统内置计算方式"
}
```



---------------------

##### 4.计算类型下拉菜单

**Request**

- Method : GET
- URI : /ic/computeType/computeTypeList
- Body : 



**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": true,
    "data": [
        {
            "name": "统计",
            "code": "count",
            "id": 1
        },
        {
            "name": "求和",
            "code": "sum",
            "id": 2
        },
        {
            "name": "求关联",
            "code": "association",
            "id": 3
        },
        {
            "name": "求平均",
            "code": "average",
            "id": 4
        }
    ],
    "msg": null
}
```

___________
##### 5.计算方式分页列表

**Request**

- Method : GET
- URI :  /ic/computeType/list
- Body : 

| 字段名   | 类型   | 是否必须 | 说明               | 例子 |
| -------- | ------ | -------- | ------------------ | ---- |
| type     | int    | 否       | 1系统内置，2自定义 |      |
| query    | string | 否       | 查询字符串         |      |
| pageNo   | int    | 是       | 页数               |      |
| pageSize | int    | 是       | 每页记录数         |      |

**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": true,
    "data": {
        "callback": null,
        "scriptWrapping": null,
        "pageNo": 1,
        "pageSize": 10,
        "itemCount": 4,
        "pageCount": null,
        "startOffset": 0,
        "items": [
            {
                "id": 4,
                "name": "求平均",
                "code": "average",
                "description": "求平均",
                "status": 1,
                "createTime": "2018-09-27 15:13:15.0",
                "modifyTime": "2018-09-27 15:13:15.0",
                "cmUser": "管理员/管理员"
            },
            {
                "id": 3,
                "name": "求关联",
                "code": "association",
                "description": "求关联",
                "status": 1,
                "createTime": "2018-09-27 15:12:48.0",
                "modifyTime": "2018-09-27 15:12:48.0",
                "cmUser": "管理员/管理员"
            },
            {
                "id": 2,
                "name": "求和",
                "code": "sum",
                "description": "求和",
                "status": 1,
                "createTime": "2018-09-27 15:12:21.0",
                "modifyTime": "2018-09-27 15:12:21.0",
                "cmUser": "管理员/管理员"
            },
            {
                "id": 1,
                "name": "统计",
                "code": "count",
                "description": "统计",
                "status": 1,
                "createTime": "2018-09-27 15:11:00.0",
                "modifyTime": "2018-09-27 15:11:24.0",
                "cmUser": "管理员/管理员"
            }
        ],
        "needQueryCount": false
    },
    "msg": null
}
```



___________
##### 6.获取计算方式详情

**Request**

- Method : GET
- URI :   /ic/computeType/${id}
- Body : 

**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": false,
    "data": null,
    "msg": "未找到记录，可能已被删除"
}


///////////////////////
{
    "success": true,
    "data": {
        "id": 7,
        "name": "test",
        "code": "test",
        "description": "test",
        "type": 2,
        "fileIds": "1,2",
        "status": 0,
        "script": "test",
        "supportDataType": "1,2"
    },
    "msg": null
}
```





___________

##### 7.name、code重复校验

**Request**

- Method : GET
- URI : /ic/computeType/checkDuplicate
- Body : 

| 字段名 | 类型   | 是否必须 | 说明 | 例子 |
| ------ | ------ | -------- | ---- | ---- |
| name   | string | 否       |      |      |
| code   | string | 否       |      |      |

**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": true,
    "data": [],
    "msg": null
}

{
    "success": true,
    "data": [
        1
    ],
    "msg": "存在同name或者code计算方式"
}
```





--------------------------------

##### 8.上传文件

___________

**Request**

- Method : POST
- URI :  /ic/computeType/
- Body : 

| 字段名 | 类型      | 是否必须 | 说明 | 例子 |
| ------ | --------- | -------- | ---- | ---- |
| file   | form-data | 是       | 文件 |      |

**Response**

- Content-Type : `application/json`
- Body 

```json
{
    "success": true,
    "data": 1,
    "msg": "上传成功"
}
```
