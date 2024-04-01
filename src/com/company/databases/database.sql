
Вывести все персонажей у которых в инвентаре содержатся предметы с редкостью 5
select c.name, i.name, i.rarity
from character as c, item as i, inventory as inv
where (c.id=inv.character_id) and (i.id=inv.item_id) and (i.rarity=5);

--Вывести по 3 самых тяжелых вещи в инвентаре для каждого персонажа
select c.name, i.name
from character as c, item as i, inventory as inv
where (c.id = inv.character_id) and (i.id = inv.item_id);

--Вывести по 3 самых тяжелых вещи в инвентаре для каждого персонажа
drop table if exists weights;
create temp table weights as
select c.id, c.name, i.name, i.weight
from character as c, item as i, inventory as inv
where (c.id=inv.character_id) and (i.id=inv.item_id)
order by c.name, i.weight desc;

--Каждому гному раздать по серебряной руде (Silver ore)
select c.id, (select id from item
where name='Silver Ore')
from character as c
inner join race as r
on(c.race_id=r.id)
where r.name='Dwarves';

drop table if exists dwarves;
create temp table dwarves as
select c.id, (select id from item
where name='Silver Ore')
from character as c
inner join race as r
on(c.race_id=r.id)
where r.name='Dwarves';


select * from weights as w
where (select count(*) from weights where w.id=id and weight>=w.weight)<=3;

select c.name, i.name, i.weight
from character as c, item as i, inventory as inv
where (c.id=inv.character_id) and (i.id=inv.item_id)
group by i.weight;

select c.name, r.name, cl.name
from character as c, race as r, class as cl
where (r.name == "Humans") and (cl.name=="Archer")
group by c.id;

select count(*) from(select c.name, r.name, l.name
from character as c, race as r, class as l
where (c.race_id=r.id)and(c.class_id=l.id));

select count(*) from(
select c.name, r.name
from character as c, race as r
where (c.race_id=r.id)and(c.class_id=cl.id)and(r.name= "Humans") and (cl.name="Archer"));

--Вывести количество персонажей в каждой расе

select r.name, count(c.id)
from character as c, race as r
where (c.race_id=r.id)
group by r.id;


-----------------------------------------------------------------
Вывести имена персонажей и список их предметов
select c.name, i.name
from character as c, item as i, inventory as inv
where (c.id = inv.character_id) and (i.id = inv.item_id) and (c.id=2);

select count(*)
from character as c, item as i, inventory as inv
where (c.id = inv.character_id) and (i.id = inv.item_id) and (c.id=2);

select count(*) from inventory where character_id=2;
------------------------------------------------------------------------------------
select c.name, r.name
from character as c, race as r
where (c.race_id=r.id);
----
select c.name, r.name
from character as c
inner join race as r
on (c.race_id=r.id);
------------------------------------------------------------------------------------
insert into character(name) values ('Vulrend');

insert into character(name) values ('Vulrend');
insert into character(name) values ('Werunth');
insert into character(name) values ('Harelath');
insert into character(name) values ('Zuroth');
insert into character(name) values ('Dorath');
insert into character(name) values ('Sharian');
insert into character(name) values ('Maiel');
insert into character(name) values ('Melron');
insert into character(name) values ('Melkorn');
insert into character(name) values ('Meralia');
insert into character(name) values ('Galeron');
insert into character(name) values ('Dalior');
insert into character(name) values ('Oristor');
insert into character(name) values ('Yverath');
insert into character(name) values ('Deraldorion');
insert into character(name) values ('Doriolin');
insert into character(name) values ('Melion');
insert into character(name) values ('Turimbar');
insert into character(name) values ('Turin');
insert into character(name) values ('Reolath');
insert into character(name) values ('Theolas');
insert into character(name) values ('Eoner');
insert into character(name) values ('Eoren');
insert into character(name) values ('Alwund');
insert into character(name) values ('Tarathiel');
insert into character(name) values ('Throk');
insert into character(name) values ('Eldron');
insert into character(name) values ('Eltharien');
insert into character(name) values ('Elthar');
insert into character(name) values ('Relath');
insert into character(name) values ('Garndal');
insert into character(name) values ('Vuldred');
insert into character(name) values ('Njorn');
insert into character(name) values ('Perulian');
insert into character(name) values ('Loruthan');

insert into item(name) values('');

insert into item(name) values('Adobe');
insert into item(name) values('Aluminum Ingot');
insert into item(name) values('Animal Bone');
insert into item(name) values('Animal Fat');
insert into item(name) values('Animal Hide');
insert into item(name) values('Bamboo Stick');
insert into item(name) values('Beeswax');
insert into item(name) values('Black Dye');
insert into item(name) values('Blue Alloy');
insert into item(name) values('Blue Coral Powder');
insert into item(name) values('Blue Dye');
insert into item(name) values('Blue Metal');
insert into item(name) values('Bolts');
insert into item(name) values('Brick');
insert into item(name) values('Bronze Ingot');
insert into item(name) values('Carved Wood');
insert into item(name) values('Cattail');
insert into item(name) values('Cement');
insert into item(name) values('Charcoal');
insert into item(name) values('Clay');
insert into item(name) values('Cloth');
insert into item(name) values('Coal');
insert into item(name) values('Copper Ingot');
insert into item(name) values('Copper Ore');
insert into item(name) values('Crafted Leather');
insert into item(name) values('Cursed Wood');
insert into item(name) values('Duct Tape');
insert into item(name) values('Electronic Components');
insert into item(name) values('Empty Can');
insert into item(name) values('Feather');
insert into item(name) values('Fertile Soil');
insert into item(name) values('Firewood');
insert into item(name) values('Flint');
insert into item(name) values('Gas');
insert into item(name) values('Glass');
insert into item(name) values('Glue');
insert into item(name) values('Gold Ingot');
insert into item(name) values('Gold Nugget');
insert into item(name) values('Gravel');
insert into item(name) values('Green Dye');
insert into item(name) values('Hard Skin');
insert into item(name) values('Hardwood');
insert into item(name) values('Iron Ingot');
insert into item(name) values('Iron Ore');
insert into item(name) values('Jade');
insert into item(name) values('Large Stone');
insert into item(name) values('Leather');
insert into item(name) values('Leather Straps');
insert into item(name) values('Marble');
insert into item(name) values('Metal Scraps');
insert into item(name) values('Metal Shard');
insert into item(name) values('Metal Wire');
insert into item(name) values('Monster Scales');
insert into item(name) values('Nails');
insert into item(name) values('Orange Dye');
insert into item(name) values('Paper');
insert into item(name) values('Plant Fiber');
insert into item(name) values('Plastic');
insert into item(name) values('Purple Coral Powder');
insert into item(name) values('Purple Dye');
insert into item(name) values('Quartz');
insert into item(name) values('Red Coral Powder');
insert into item(name) values('Red Dye');
insert into item(name) values('Rooftiles');
insert into item(name) values('Rope');
insert into item(name) values('Rubber');
insert into item(name) values('Sand');
insert into item(name) values('Sharp Stone');
insert into item(name) values('Silicon');
insert into item(name) values('Silver Ingot');
insert into item(name) values('Silver Ore');
insert into item(name) values('Slate');
insert into item(name) values('Small Stone');
insert into item(name) values('Steel Ingot');
insert into item(name) values('Steel Plates');
insert into item(name) values('Stick');
insert into item(name) values('Straws');
insert into item(name) values('Thread');
insert into item(name) values('Timber');
insert into item(name) values('Tin');
insert into item(name) values('Titanium Dust');
insert into item(name) values('Titanium Ingot');
insert into item(name) values('Turquoise');
insert into item(name) values('Varnish');
insert into item(name) values('Whetstone');
insert into item(name) values('White Coral Powder');
insert into item(name) values('White Dye');
insert into item(name) values('Wood Log');
insert into item(name) values('Wood Planks');
insert into item(name) values('Wool');
insert into item(name) values('Yellow Coral Powder');
insert into item(name) values('Yellow Dye');