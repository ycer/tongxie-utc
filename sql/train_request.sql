SELECT trainId
FROM train_order
WHERE station LIKE '%南京%'

SELECT trainId, station, stationOrder
FROM train_order
WHERE station LIKE '%南京%'
GROUP BY trainId

SELECT trainId, station, stationOrder
FROM train_order
WHERE station LIKE '%北京%'
GROUP BY trainId

SELECT a.trainId, a.station, a.stationOrder, b.trainId, b.station, b.stationOrder
FROM train_order AS a, (
SELECT trainId, station, stationOrder
FROM train_order
WHERE station LIKE '%北京%'
GROUP BY trainId
) AS b
WHERE a.station  LIKE '%南京%' 
	AND a.trainId = b.trainId
	AND a.stationOrder < b.stationOrder


SELECT a.trainId, a.station, a.stationOrder, a.priceHardSeat, a.priceSoftSeat, a.priceHardBerth, a.priceSoftBerth , 
	b.trainId, b.station, b.stationOrder, b.priceHardSeat, b.priceSoftSeat, b.priceHardBerth, b.priceSoftBerth
FROM (
	SELECT trainId,station, stationOrder, priceHardSeat, priceSoftSeat, priceHardBerth, priceSoftBerth 
	FROM train_order
	WHERE station LIKE '%北京%'
	GROUP BY trainId
	) AS a, (
	SELECT trainId, station, stationOrder, priceHardSeat, priceSoftSeat, priceHardBerth, priceSoftBerth 
	FROM train_order
	WHERE station LIKE '%南京%'
	GROUP BY trainId
	) AS b
WHERE a.trainId = b.trainId
	AND a.stationOrder < b.stationOrder



SELECT a.trainId,a.type, a.station, a.stationOrder, a.priceHardSeat, a.priceSoftSeat, a.priceHardBerth, a.priceSoftBerth , 
	b.trainId, b.station, b.stationOrder, b.priceHardSeat, b.priceSoftSeat, b.priceHardBerth, b.priceSoftBerth
FROM (
	SELECT trainId, station, stationOrder, priceHardSeat, priceSoftSeat, priceHardBerth, priceSoftBerth 
	FROM train_order
	WHERE station LIKE '%北京%'
	GROUP BY trainId
	) AS a, (
	SELECT trainId, station, stationOrder, priceHardSeat, priceSoftSeat, priceHardBerth, priceSoftBerth 
	FROM train_order
	WHERE station LIKE '%南京%'
	GROUP BY trainId
	) AS b
WHERE a.trainId = b.trainId
	AND a.stationOrder < b.stationOrder



SELECT a.trainId,a.type, a.station, a.stationOrder, a.priceHardSeat, a.priceSoftSeat, a.priceHardBerth, a.priceSoftBerth , 
	b.trainId, b.station, b.stationOrder, b.priceHardSeat, b.priceSoftSeat, b.priceHardBerth, b.priceSoftBerth
FROM train_order AS a, (
	SELECT trainId, station, stationOrder, priceHardSeat, priceSoftSeat, priceHardBerth, priceSoftBerth 
	FROM train_order
	WHERE station LIKE '%南京%'
	GROUP BY trainId
	) AS b
WHERE a.station  LIKE '%北京%' 
	AND a.trainId = b.trainId
	AND a.stationOrder < b.stationOrder


UPDATE 
	train_order AS a,
	(SELECT trainId, MAX(stationOrder) AS endOrder FROM train_order GROUP BY trainId) AS b
SET
	a.isEndStation = TRUE
WHERE
	a.id > 0 AND a.id < 5000 AND
	a.trainId = b.trainId AND a.stationOrder = b.endOrder;
	

SELECT 	id, 
	arriveTime, 
	DAY, 
	departureTime, 
	distance, 
	priceHardBerth, 
	priceHardSeat, 
	priceSoftBerth, 
	priceSoftSeat, 
	station, 
	stationOrder, 
	trainId, 
	TYPE
	 
	FROM 
	tongxie.train_order 
	LIMIT 0, 50;