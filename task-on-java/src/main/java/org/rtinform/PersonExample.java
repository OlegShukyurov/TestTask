package org.rtinform;

import java.util.Objects;

public class PersonExample {



    private int age;
    private String name;

    public PersonExample(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonExample{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonExample that = (PersonExample) o;

        if (age != that.age) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
