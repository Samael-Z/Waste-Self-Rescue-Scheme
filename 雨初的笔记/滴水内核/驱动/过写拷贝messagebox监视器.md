+ `!vtop` 命令可以有两个参数，第一个参数是CR3 寄存器的值，第二个参数是要查询的虚拟地址是多少，比如



## 笔记

+ 写拷贝的内存和只读的内存在尝试写的时候都会进到异常里面去。

+ 每个进程都有一个 `Eprocess` 结构体，这个结构体里面有一个 `VADROOT` ，这是一个二叉树，每一个结点都会记录 **开始地址** ， **结束地址** ，**内存的类型** 。

  `vad` 树里面的记录的单位是4KB。

  ![image-20210120152330473](https://raw.githubusercontent.com/smallzhong/picgo-pic-bed/master/image-20210120152330473.png)

+ 他这里的思路是先构造一个中断门，然后把 `MessageBox` 前4位patch为 `int XX` ，这样可以直接进到中断，然后就可以记录调用

  ![image-20210120164225356](https://raw.githubusercontent.com/smallzhong/picgo-pic-bed/master/image-20210120164225356.png)
  
+ 不能对一个 `PVOID` 解引用，要转为 `PULONG` 再解引用。

+ `C030000` 就是PDE的地址

+ ![image-20210123122320471](https://raw.githubusercontent.com/smallzhong/picgo-pic-bed/master/image-20210123122320471.png)

  最后一个参数最先入栈
  
+ **常用的内核函数**

  | C语言    | 内核             |
  | -------- | ---------------- |
  | `malloc` | `ExAllocatePool` |
  | `memset` | `RtlFillMemory`  |
  | `memcpy` | `RtlMoveMemory`  |
  | `free`   | `ExFreePool`     |

+ 常用的字符串函数

  | 功能 | ANSI_STRING字符串            | UNICODE_STRING字符串         |
  | ---- | ---------------------------- | ---------------------------- |
  | 创建 | RtlInitAnsiString            | RtlInitUnicodeString         |
  | 复制 | RtlCopyString                | RtlCopyUnicodeString         |
  | 比较 | RtlCompareString             | RtlCompareUnicoodeString     |
  | 转换 | RtlAnsiStringToUnicodeString | RtlUnicodeStringToAnsiString |
  
+ ![image-20210124144847976](https://raw.githubusercontent.com/smallzhong/picgo-pic-bed/master/image-20210124144847976.png)



## 思路

+ 另外申请一个线性地址，映射到MessageBoxA的物理页，设置PTE的R/W属性，使其可读写。

+ ![image-20210120163433543](https://raw.githubusercontent.com/smallzhong/picgo-pic-bed/master/image-20210120163433543.png)

+ [ ] 先写一个inlinehook `messagebox` 的demo

+ [ ] 修改PTE/改VAD树二选一

+ [ ] 0环3环通信

+ [ ] 遍历kernel32，插入shellcode

+ [ ] 把PTE和PDE传进去

+ [ ] 不仅要修改RW，还要修改US

  

  





## 问题

+ 











