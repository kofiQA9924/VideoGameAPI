package com.VGameAPI.Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Created by RUTHERFORD on 3/5/2021.
 */
public class Reporter extends TestListenerAdapter {
    public static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    @Override
    public void onStart(ITestContext testContext) {
        extentHtmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+System.currentTimeMillis()+"Reports.html");
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);


        extentHtmlReporter.config().setReportName("VideoGameAPI Report");
        extentHtmlReporter.config().setDocumentTitle("APITest Report");
        extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        extentHtmlReporter.config().setTheme(Theme.DARK);

        extentReports.setSystemInfo("Hostname","Localname");
        extentReports.setSystemInfo("OS","Windows 10");
        extentReports.setSystemInfo("QA Engineer","J.Stephenson");
        extentReports.setSystemInfo("Programming Language","JAVA");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extentReports.flush();
    }
}
