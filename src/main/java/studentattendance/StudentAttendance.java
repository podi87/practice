package com.evosoft.studentattendance;

/**
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * <p>
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
 * <p>
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * <p>
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttendance {

    public boolean checkRecord(final String record) {
        char[] array = record.toCharArray();
        int counterA = 0;
        int counterL = 0;
        for (char c : array) {
            if (c == 'A') {
                counterA++;
            } else if (record.contains("LLL")) {
                counterL++;
            }
        }
        return counterA <= 1 && counterL <= 0;
    }
}
