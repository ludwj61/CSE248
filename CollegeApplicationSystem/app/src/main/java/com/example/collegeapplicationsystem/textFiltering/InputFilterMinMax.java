package com.example.collegeapplicationsystem.textFiltering;

import android.text.InputFilter;
import android.text.Spanned;

// edited from https://stackoverflow.com/questions/14212518/is-there-a-way-to-define-a-min-and-max-value-for-edittext-in-android

public class InputFilterMinMax implements InputFilter {

    private int min;
    private int max;

    public InputFilterMinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public InputFilterMinMax(String min, String max) {
        this.min = Integer.parseInt(min);
        this.max = Integer.parseInt(max);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            int input = Integer.parseInt(dest.toString() + source.toString());
            if (isInRange(min, max, input))
                return null;
        } catch (NumberFormatException nfe) {
        }
        return "";
    }

    private boolean isInRange(int a, int b, int c) {
        if (b > a) {
            if (c >= a && c <= b) {
                return true;
            }
        } else {
            if (c >= b && c <= a) {
                return true;
            }
        }
        return false;
    }
}
