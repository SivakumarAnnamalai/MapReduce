package com.jpasolutions.keyword;

import com.jpasolutions.secondarySorting.Student;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * Created by nrelate on 2/6/15.
 */
public class KeywordGroupComparator extends WritableComparator {
    protected KeywordGroupComparator(){
        super(Student.class,true);
    }

    public int compare(WritableComparable w1,WritableComparable w2){
        Student s1 = (Student) w1;
        Student s2 = (Student) w2;
        return s1.getStudentName().compareTo(s2.getStudentName());
    }
}