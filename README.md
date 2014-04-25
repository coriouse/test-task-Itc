Please create a Java based webapplication  that can import some geometric data.

It could be a simple example for a GIS-Software import.

Data are stored in a simple Text file:
TYPE OF SHAPE;ID;DESCRIPTION;GEOMETRIC SETTINGS DEPEND ON TYPE OF SHAPE
CIRCLE;4711;BUILDING 1;7;30;50 (Radius,Easting,Northing)
SQUARE;4712; BUILDING 3; 0.0;0.0;0.0;10.0;10.0;10.0;10.0;0.0 (coordinates of the cornaers)

The selection of the file is based on upload or if there is a problem with upload then import the file from a local folder on server.

First the program should read the settings from the file and store the information in objects for further calculations.
Please create a object hierarchy. Each object should implement special methods to handle the import and calculation of the area (Hint: IGetArea Interface).

Create now a button for export (download) the areas of selectable shapes (selection of type as combobox) as csv and show the result (area caluculated) on a simple table inside the page.
Create now a further button to export the stored content to XML or JSON 

Be aware, that the content of an example file can be uncomplete or has wrong data.
Please handle this.