package jm.task.core.jdbc.model;

import jdk.jfr.DataAmount;

import javax.persistence.*;
import java.io.Serializable;

@Entity//говорит о том что данный класс будет персистентным объектом, который будет связан с таблицей базы данных
/*Serializable - интерфейс маркер. Это значит что class User и все экземпляры будут иметь возможность
//сериалицации т.е. представление в двоичном виде. Доупустим если будет вебприложение и если нужно будет сохранить
в виде атрибута объект User*/
public class User implements Serializable {
    @Id//это указание, что поле является идентификатором объектов этого класса
    @GeneratedValue (strategy = GenerationType.IDENTITY)//генерация id через Autoincrement в SQL, поэтому для id отсутствует сеттер, и в конструкторе мы его тоже не задаем
    private Long id;

    @Column()//указывает на связь имени поля "name" с ооответствующей колонкой таблицы. Если имя отличается то его можно указать в скобках
    private String name;

    @Column
    private String lastName;

    @Column
    private Byte age;

    public User() {

    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
