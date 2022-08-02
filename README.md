# Ошибка с корректным отображением символов "И" и подобной латиницы

![](src/main/resources/Screenshot_3.png)


внутри `Custom VM Options...:` добавляем следующую строчку:

``` java
-Dfile.encoding=UTF-8
```
**Помощь** | 
**Отредактируйте** пользовательские параметры виртуальной машины, 
затем ***перезапустите*** `IntelliJ IDEA.`

![](src/main/resources/Screenshot_4.png)