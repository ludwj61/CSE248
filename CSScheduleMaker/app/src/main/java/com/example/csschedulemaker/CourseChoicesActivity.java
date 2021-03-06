package com.example.csschedulemaker;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csschedulemaker.courseData.Course;
import com.example.csschedulemaker.courseData.CourseTypes;
import com.example.csschedulemaker.courseData.Semester;

import java.util.ArrayList;
import java.util.Collections;

public class CourseChoicesActivity extends AppCompatActivity {

    private CourseTypes selectedType;
    private TextView titleTextView;
    private Semester semesterFromPopup;
    private RecyclerView recyclerView;
    private CourseChoiceAdapter courseChoiceAdapter;
    private ArrayList<Course> courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_choices_acitivty);

        courseList = new ArrayList<>();
        setTitle();
        setSemester();
        filterSemester();
        Collections.sort(courseList, Course.courseNumComparator);

        recyclerView = (RecyclerView) findViewById(R.id.course_choice_recycler);

        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(16);
        recyclerView.addItemDecoration(spacesItemDecoration);

        RecyclerView.ItemDecoration itemDecorationHorizLine = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecorationHorizLine);

        courseChoiceAdapter = new CourseChoiceAdapter(courseList, semesterFromPopup, this);

        recyclerView.setAdapter(courseChoiceAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setTitle() {
        selectedType = (CourseTypes) (getIntent().getSerializableExtra("chosenCourseType"));
        TextView titleTextView = (TextView) findViewById(R.id.course_select_title);
        titleTextView.setText(selectedType.displayName());
    }

    private void setSemester() {
        semesterFromPopup = (Semester) (getIntent().getSerializableExtra("originalClassListFromTypePopup"));
        // System.out.println(semesterFromPopup.getSemesterName());
    }

    private void filterSemester() {
        ArrayList<Course> allCourses = new ArrayList<>();
        allCourses.addAll(semesterFromPopup.getCourseBag().getCourseHash().values());

        switch (selectedType) {
            case COMPSCI:
                for (Course course : allCourses) {
                    if (course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("CSE")) {
                        courseList.add(course);
                    }
                }
                break;
            case ENGLISH:
                for (Course course : allCourses) {
                    if (course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("ENG")) {
                        courseList.add(course);
                    }
                }
                break;
            case GYM:
                for (Course course : allCourses) {
                    if (course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("PED")) {
                        courseList.add(course);
                    }
                }
                break;
            case HISTORY:
                for (Course course : allCourses) {
                    if (course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("HIS")) {
                        courseList.add(course);
                    }
                }
                break;
            case HUMANITY:
                for (Course course : allCourses) {
                    if (course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("HUM")) {
                        courseList.add(course);
                    }
                }
                break;
            case LANGUAGE:
                for (Course course : allCourses) {
                    if (course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("GER") ||
                            course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("FRE") ||
                            course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("CHI") ||
                            course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("ASL")) {
                        courseList.add(course);
                    }
                }
                break;
            case MATH:
                for (Course course : allCourses) {
                    if (course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("MAT")) {
                        courseList.add(course);
                    }
                }
                break;
            case SCIENCE:
                for (Course course : allCourses) {
                    if (course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("BIO") ||
                            course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("CHE") ||
                            course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("PHY") ||
                            course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("AST") ||
                            course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("ESC")) {
                        courseList.add(course);
                    }
                }
                break;
            case SOCIOLOGY:
                for (Course course : allCourses) {
                    if (course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("ANT") ||
                            course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("GEO") ||
                            course.getCourseTitleShort().substring(0, 3).equalsIgnoreCase("POL")) {
                        courseList.add(course);
                    }
                }
                break;
            default:
                break;
        }
    }

}
