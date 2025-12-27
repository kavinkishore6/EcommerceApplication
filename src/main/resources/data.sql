-- Insert default products only if they don't already exist
INSERT IGNORE INTO product (name, description, price, image_url) VALUES
('Samsung Galaxy S24', '512 GB & Titanium Grey', 49000, '/img/phone1.PNG'),
('Apple 16 Pro', '128GB & White', 128000, '/img/phone2.PNG'),
('One Plus 11 5G', '256GB RAM and Titan Black', 690000, '/img/phone3.PNG'),
('Nothing 3A', '256GB RAM and Grey', 20000, '/img/phone4.PNG'),
('Boat Airpods', '14 Hours playtime and Green', 1200, '/img/pods1.PNG'),
('Realme Earbuds', '38 Hours playtime and Yellow', 1800, '/img/pods2.PNG'),
('Xiomi Earbuds', '17 Hours playtime and Black', 1000, '/img/pods3.PNG'),
('Boult Mustang', '10 Hours playtime and Black', 1100, '/img/pods4.PNG');