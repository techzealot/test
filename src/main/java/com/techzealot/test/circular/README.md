问题产生的原因，spring循环依赖注入原理：
查问题的时候，找到一篇大佬写的文章，讲述的特别详细：https://blog.csdn.net/lianhuazy167/article/details/66967673，摘抄部分核心文字过来，以让大家更好的理解。

步骤1：A依赖B、C依赖B，B依赖C，并且B实现类的方法上存在@async注解，即B在实例化完成前会生成代理。

步骤2：A开始create，发现B未实例化，于是先cache A。

步骤3：B开始create，发现C未实例化，于是先cache B。

步骤4：C开始create，发现B已实例化，取出cache的B，注入C中，C finish。

(为什么B未实例化完就注入到C中了？that is not fully initialized yet - a consequence of a circular reference，因为存在循环依赖，所以允许先注入。猜测未做是否被代理的检测)

步骤5：生成B的代理类B@108e。

步骤6：B@108e注入到A时，发现B@108e的原始实例B已注入到循环引用的C中，却没有使用B的最终代理类B@108e，所以抛异常。