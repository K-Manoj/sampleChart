package cool;

import java.awt.Color;
import java.io.File;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class JFreeChartLineChartExample extends JFrame {

   private static final long serialVersionUID = 1L;

   public JFreeChartLineChartExample(String applicationTitle, String chartTitle) {
        super(applicationTitle);

        // based on the dataset we create the chart
        JFreeChart pieChart = ChartFactory.createXYLineChart(chartTitle, "Age Months", "Mass KiloGrams", createDataset(),PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = pieChart.getXYPlot();
        NumberAxis numberAxis = (NumberAxis) xyplot.getDomainAxis();
        numberAxis.setTickUnit(new NumberTickUnit(2));
        
        NumberAxis numberAxis1 = (NumberAxis) xyplot.getRangeAxis();
        numberAxis1.setTickUnit(new NumberTickUnit(2));

        // Adding chart into a chart panel
        ChartPanel chartPanel = new ChartPanel(pieChart);
      
        // settind default size
        chartPanel.setPreferredSize(new java.awt.Dimension(700, 500));
        
        xyplot.setBackgroundPaint(Color.WHITE);
        
        xyplot.setRangeGridlinesVisible(true);
        xyplot.setRangeGridlinePaint(Color.BLACK);
         
        xyplot.setDomainGridlinesVisible(true);
        xyplot.setDomainGridlinePaint(Color.BLACK);
      
        // add to contentPane
        setContentPane(chartPanel);
        File XYChart = new File( "XYLineChart.jpeg" ); 
        
        try{
        	ChartUtilities.saveChartAsJPEG( XYChart, pieChart, 700, 500);
        }
        catch(Exception e)
        {}
    }
  
   private XYDataset createDataset() {
     
      final XYSeries person1 = new XYSeries( "Person-1" );
      person1.add(2,2);
      person1.add(4,2.2);
      person1.add( 5,3 );
      person1.add(6,3.2);
      person1.add(8,4);
      person1.add(10,4.5);
      person1.add(34,6);
      final XYSeries person2 = new XYSeries( "Person-2" );
      person2.add(2,6);
      person2.add(20,8 );
      person2.add(36,12);
      final XYSeries person3 = new XYSeries( "Person-3" );
      person3.add(2,12 );
      person3.add(18,14);
      person3.add(34,18);
      final XYSeriesCollection dataset = new XYSeriesCollection( );
      dataset.addSeries( person1 );
      dataset.addSeries( person2 );
      dataset.addSeries( person3 );
     
      return dataset;    
  }

   public static void main(String[] args) {
      JFreeChartLineChartExample chart = new JFreeChartLineChartExample("SAMPLE LINE CHART", "");
      chart.pack();
      chart.setVisible(true);
   }
}