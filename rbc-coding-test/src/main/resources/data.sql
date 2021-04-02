DROP TABLE IF EXISTS stock;

CREATE TABLE stock(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  quarter NUMBER(5) NOT NULL,
  stock VARCHAR(50) NOT NULL,
  date Date NOT NULL,
  open DECIMAL,
  high DECIMAL,
  low DECIMAL,
  close DECIMAL,
  volume NUMBER(100),
  percentage_change_price DECIMAL,
  percent_change_volume_over_last_wk DECIMAL DEFAULT NULL,
  previous_weeks_volume NUMBER(100),
  next_weeks_open DECIMAL,
  next_weeks_close DECIMAL,
  percent_change_next_weeks_price DECIMAL,
  days_to_next_dividend NUMBER(10),
  percent_return_next_dividend DECIMAL
);
