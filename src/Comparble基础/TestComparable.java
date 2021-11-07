package Comparble基础;

public class TestComparable {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAge(12);
        s1.setUsername("zhangsan");

        Student s2 = new Student();
        s2.setAge(15);
        s2.setUsername("wangwu");

        Comparable max = getMax(s1, s2);
        System.out.println(max);
    }

    public static Comparable getMax(Comparable c1 , Comparable c2){
        //调用比较规则
        int res = c1.compareTo(c2);

        //对结果进行筛选
        if(res >= 0) {
            return c1;
        }else{
            return c2;
        }
    }
}
