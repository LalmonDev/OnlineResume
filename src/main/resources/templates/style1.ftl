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