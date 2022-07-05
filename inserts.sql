INSERT INTO regiao (id,regiao,qtd_exames
) VALUES (uuid(), 'Norte','44');
INSERT INTO regiao (id,regiao,qtd_exames) VALUES (uuid(),'Nordeste','13832');
INSERT INTO regiao (id,regiao,qtd_exames) VALUES (uuid(),'Sudeste','89657');
INSERT INTO regiao (id,regiao,qtd_exames) VALUES (uuid(),'Sul','122');
INSERT INTO regiao (id,regiao,qtd_exames) VALUES (uuid(),'Centro-Oeste','2581');



INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (1, '0','10','Até 10 anos');
INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (2, '11','14','Entre 11 e 14 anos');
INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (3, '15','19','Entre 15 e 19 anos');
INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (4, '20','24','Entre 20 e 24 anos');
INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (5, '25','29','Entre 25 e 29 anos');
INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (6, '30','34','Entre 30 e 34 anos');
INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (7, '35','39','Entre 35 e 39 anos');
INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (8, '40','44','Entre 40 e 44 anos');
INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (9, '45','49','Entre 45 e 49 anos');
INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (10, '50','54','Entre 50 e 54 anos');
INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (11, '55','59','Entre 55 e 59 anos');
INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (12, '60','64','Entre 60 e 64 anos');
INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (13, '65','69','Entre 65 e 69 anos');
INSERT INTO faixa_etaria (id, faixai,faixan,descricao) VALUES (14, '70','150','Acima de 70');


INSERT INTO incidencia (id, regiao_id, mes, faixa_id, qtd_exames) VALUES (1, 1,5,2,1);
INSERT INTO incidencia (id, regiao_id, mes, faixa_id, qtd_exames) VALUES (2, 1,5,4,2);