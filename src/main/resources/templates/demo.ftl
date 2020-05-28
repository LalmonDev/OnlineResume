package ${package};

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
* @author ${user}
* @date ${date}
* @description
*/
@Entity
@Table(name = "${tableName}")
public class ${className} implements Serializable {
private static final long serialVersionUID = 1L;
<#list data as row>
    ${row}
</#list>
}


% 导言区
\documentclass{article}

% 导入中文宏
\usepackage{ctex}

% 构建命令,取别名，使用degree 代替 ^ circ
\newcommand\degree{^\circ}

\title{\heiti 测试文件}
\author{\kaishu LalmonDev}
\date{\today}
% 正文区
\begin{document}
\maketitle
${info}


这就是测试
\end{document}