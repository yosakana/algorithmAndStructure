package Comparble基础;

public class Student implements Comparable<Student>{
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }


    //在bean里定义一个比较规则
    @Override
    public int compareTo(Student o) {

        return this.age - o.age;
    }
}
