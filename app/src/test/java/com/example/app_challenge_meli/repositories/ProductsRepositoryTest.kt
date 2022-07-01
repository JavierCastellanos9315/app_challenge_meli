package com.example.app_challenge_meli.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.app_challenge_meli.model.description.Description
import com.example.app_challenge_meli.model.item.Item
import com.example.app_challenge_meli.model.search.Search
import com.google.gson.Gson
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import retrofit2.Response.success


internal class ProductsRepositoryTest {
    private lateinit var productsRepository: ProductsRepository
    @RelaxedMockK
    private lateinit var productsRemoteData: ProductsRemoteData

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        productsRepository = ProductsRepository()
        productsRepository.repository = productsRemoteData
    }

    @Test
    fun `when is called get products by query`() = runBlocking {
        //Given
        val jsonObject = JSONObject("""{
    "site_id": "MCO",
    "country_default_time_zone": "GMT-05:00",
    "query": "nevera",
    "paging": {
        "total": 1988,
        "primary_results": 1000,
        "offset": 0,
        "limit": 50
    },
    "results": [
        {
        "id": "MCO903901929",
        "site_id": "MCO",
        "title": "Nevera No Frost Mabe Rma250fjcl1 Platino Con Freezer 250l 110v",
        "seller": {
            "id": 355766067,
            "permalink": null,
            "registration_date": null,
            "car_dealer": false,
            "real_estate_agency": false,
            "tags": null
        },
        "price": 1756900,
        "prices": {
            "id": "MCO903901929",
            "prices": [
                {
                    "id": "2",
                    "type": "standard",
                    "amount": 1756900,
                    "regular_amount": null,
                    "currency_id": "COP",
                    "last_updated": "2022-06-11T15:43:46Z",
                    "conditions": {
                        "context_restrictions": [],
                        "start_time": null,
                        "end_time": null,
                        "eligible": true
                    },
                    "exchange_rate_context": "DEFAULT",
                    "metadata": {}
                }
            ],
            "presentation": {
                "display_currency": "COP"
            },
            "payment_method_prices": [],
            "reference_prices": [
                {
                    "id": "3",
                    "type": "min_standard",
                    "conditions": {
                        "context_restrictions": [
                            "channel_marketplace"
                        ],
                        "start_time": null,
                        "end_time": null,
                        "eligible": true
                    },
                    "amount": 1756900,
                    "currency_id": "COP",
                    "exchange_rate_context": "DEFAULT",
                    "tags": [],
                    "last_updated": "2022-06-11T15:43:47Z"
                }
            ],
            "purchase_discounts": []
        },
        "sale_price": null,
        "currency_id": "COP",
        "available_quantity": 1,
        "sold_quantity": 2,
        "buying_mode": "buy_it_now",
        "listing_type_id": "gold_special",
        "stop_time": "2042-06-01T04:00:00.000Z",
        "condition": "new",
        "permalink": "https://www.mercadolibre.com.co/nevera-no-frost-mabe-rma250fjcl1-platino-con-freezer-250l-110v/p/MCO18520315",
        "thumbnail": "http://http2.mlstatic.com/D_894061-MLA48157961220_112021-I.jpg",
        "thumbnail_id": "894061-MLA48157961220_112021",
        "accepts_mercadopago": true,
        "installments": {
            "quantity": 36,
            "amount": 48802.78,
            "rate": 0,
            "currency_id": "COP"
        },
        "address": {
            "state_id": "CO-BOY",
            "state_name": "Boyaca",
            "city_id": "TUNPQ1RVTjFhNDk0",
            "city_name": "Tunja"
        },
        "shipping": {
            "free_shipping": true,
            "mode": "me2",
            "tags": [
                "mandatory_free_shipping"
            ],
            "logistic_type": "drop_off",
            "store_pick_up": false
        },
        "seller_address": {
            "id": "",
            "comment": "",
            "address_line": "",
            "zip_code": "",
            "country": {
                "id": "CO",
                "name": "Colombia"
            },
            "state": {
                "id": "CO-BOY",
                "name": "Boyaca"
            },
            "city": {
                "id": "TUNPQ1RVTjFhNDk0",
                "name": "Tunja"
            },
            "latitude": "",
            "longitude": ""
        },
        "attributes": [
            {
                "name": "Marca",
                "value_name": "Mabe",
                "values": [
                    {
                        "id": "19835",
                        "name": "Mabe",
                        "struct": null,
                        "source": 1
                    }
                ],
                "attribute_group_id": "OTHERS",
                "attribute_group_name": "Otros",
                "id": "BRAND",
                "value_id": "19835",
                "value_struct": null,
                "source": 1
            },
            {
                "values": [
                    {
                        "id": "2230284",
                        "name": "Nuevo",
                        "struct": null,
                        "source": 4954751883138633
                    }
                ],
                "attribute_group_id": "OTHERS",
                "source": 4954751883138633,
                "id": "ITEM_CONDITION",
                "value_id": "2230284",
                "value_struct": null,
                "attribute_group_name": "Otros",
                "name": "Condición del ítem",
                "value_name": "Nuevo"
            },
            {
                "source": 1,
                "name": "Línea",
                "value_name": "Diseño",
                "value_struct": null,
                "attribute_group_id": "OTHERS",
                "attribute_group_name": "Otros",
                "id": "LINE",
                "value_id": "5097206",
                "values": [
                    {
                        "id": "5097206",
                        "name": "Diseño",
                        "struct": null,
                        "source": 1
                    }
                ]
            },
            {
                "values": [
                    {
                        "id": "11194950",
                        "name": "RMA250FJCL1",
                        "struct": null,
                        "source": 1
                    }
                ],
                "attribute_group_id": "OTHERS",
                "source": 1,
                "id": "MODEL",
                "name": "Modelo",
                "value_id": "11194950",
                "value_name": "RMA250FJCL1",
                "value_struct": null,
                "attribute_group_name": "Otros"
            },
            {
                "attribute_group_name": "Otros",
                "source": 1,
                "value_id": "8088463",
                "values": [
                    {
                        "struct": {
                            "number": 47,
                            "unit": "kg"
                        },
                        "source": 1,
                        "id": "8088463",
                        "name": "47 kg"
                    }
                ],
                "value_name": "47 kg",
                "value_struct": {
                    "number": 47,
                    "unit": "kg"
                },
                "attribute_group_id": "OTHERS",
                "id": "WEIGHT",
                "name": "Peso"
            }
        ],
        "original_price": null,
        "category_id": "MCO115334",
        "official_store_id": 663,
        "domain_id": "MCO-REFRIGERATORS",
        "catalog_product_id": "MCO18520315",
        "tags": [
            "good_quality_picture",
            "immediate_payment",
            "cart_eligible",
            "best_seller_candidate"
        ],
        "catalog_listing": true,
        "use_thumbnail_id": true,
        "offer_score": null,
        "offer_share": null,
        "match_score": null,
        "winner_item_id": null,
        "melicoin": null,
        "discounts": null,
        "order_backend": 1
    }],
    "sort": {
        "id": "relevance",
        "name": "Más relevantes"
    },
    "available_sorts": [
        {
            "id": "price_asc",
            "name": "Menor precio"
        },
        {
            "id": "price_desc",
            "name": "Mayor precio"
        }
    ],
    "filters": [
        {
            "id": "category",
            "name": "Categorías",
            "type": "text",
            "values": [
                {
                    "id": "MCO115334",
                    "name": "Neveras y Nevecones",
                    "path_from_root": [
                        {
                            "id": "MCO5726",
                            "name": "Electrodomésticos"
                        },
                        {
                            "id": "MCO30112",
                            "name": "Refrigeración"
                        },
                        {
                            "id": "MCO115334",
                            "name": "Neveras y Nevecones"
                        }
                    ]
                }
            ]
        }
    ],
    "available_filters": [
        {
            "id": "official_store",
            "name": "Tiendas oficiales",
            "type": "text",
            "values": [
                {
                    "id": "all",
                    "name": "Todas las tiendas oficiales",
                    "results": 175
                },
                {
                    "id": "663",
                    "name": "Soelco",
                    "results": 45
                },
                {
                    "id": "153",
                    "name": "Samsung",
                    "results": 18
                },
                {
                    "id": "23",
                    "name": "Fantasia Electronica",
                    "results": 17
                },
                {
                    "id": "41",
                    "name": "Mabe",
                    "results": 32
                },
                {
                    "id": "145",
                    "name": "Whirlpool",
                    "results": 7
                },
                {
                    "id": "289",
                    "name": "Ferreteria Samir",
                    "results": 8
                },
                {
                    "id": "684",
                    "name": "Challenger",
                    "results": 8
                },
                {
                    "id": "22",
                    "name": "Electrolux",
                    "results": 10
                },
                {
                    "id": "1424",
                    "name": "Haceb",
                    "results": 10
                },
                {
                    "id": "1871",
                    "name": "Alca",
                    "results": 2
                }
            ]
        },
        {
            "id": "discount",
            "name": "Descuentos",
            "type": "number",
            "values": [
                {
                    "id": "5-100",
                    "name": "Desde 5% OFF",
                    "results": 99
                },
                {
                    "id": "10-100",
                    "name": "Desde 10% OFF",
                    "results": 73
                },
                {
                    "id": "15-100",
                    "name": "Desde 15% OFF",
                    "results": 59
                },
                {
                    "id": "20-100",
                    "name": "Desde 20% OFF",
                    "results": 43
                },
                {
                    "id": "25-100",
                    "name": "Desde 25% OFF",
                    "results": 23
                },
                {
                    "id": "30-100",
                    "name": "Desde 30% OFF",
                    "results": 14
                }
            ]
        },
        {
            "id": "state",
            "name": "Ubicación",
            "type": "text",
            "values": [
                {
                    "id": "CO-DC",
                    "name": "Bogotá D.C.",
                    "results": 1181
                },
                {
                    "id": "CO-CES",
                    "name": "Cesar",
                    "results": 175
                },
                {
                    "id": "CO-ANT",
                    "name": "Antioquia",
                    "results": 135
                },
                {
                    "id": "CO-VAC",
                    "name": "Valle Del Cauca",
                    "results": 121
                },
                {
                    "id": "CO-CUN",
                    "name": "Cundinamarca",
                    "results": 73
                },
                {
                    "id": "CO-BOY",
                    "name": "Boyaca",
                    "results": 55
                },
                {
                    "id": "CO-CAL",
                    "name": "Caldas",
                    "results": 34
                },
                {
                    "id": "CO-ATL",
                    "name": "Atlantico",
                    "results": 29
                },
                {
                    "id": "CO-SAN",
                    "name": "Santander",
                    "results": 21
                },
                {
                    "id": "CO-NSA",
                    "name": "Norte De Santander",
                    "results": 20
                },
                {
                    "id": "CO-COR",
                    "name": "Córdoba",
                    "results": 18
                },
                {
                    "id": "CO-BOL",
                    "name": "Bolivar",
                    "results": 17
                },
                {
                    "id": "CO-RIS",
                    "name": "Risaralda",
                    "results": 17
                },
                {
                    "id": "CO-TOL",
                    "name": "Tolima",
                    "results": 16
                },
                {
                    "id": "CO-MET",
                    "name": "Meta",
                    "results": 8
                },
                {
                    "id": "CO-NAR",
                    "name": "Nariño",
                    "results": 7
                },
                {
                    "id": "CO-SUC",
                    "name": "Sucre",
                    "results": 6
                },
                {
                    "id": "CO-QUI",
                    "name": "Quindio",
                    "results": 5
                },
                {
                    "id": "CO-HUI",
                    "name": "Huila",
                    "results": 4
                },
                {
                    "id": "CO-MAG",
                    "name": "Magdalena",
                    "results": 4
                },
                {
                    "id": "CO-CAU",
                    "name": "Cauca",
                    "results": 3
                },
                {
                    "id": "CO-CAS",
                    "name": "Casanare",
                    "results": 2
                },
                {
                    "id": "CO-LAG",
                    "name": "Guajira",
                    "results": 2
                },
                {
                    "id": "CO-CAQ",
                    "name": "Caqueta",
                    "results": 1
                }
            ]
        },
        {
            "id": "price",
            "name": "Precio",
            "type": "range",
            "values": [
                {
                    "id": "*-1000000.0",
                    "name": "Hasta ${'$'}1.000.000",
                    "results": 634
                },
                {
                    "id": "1000000.0-2500000.0",
                    "name": "${'$'}1.000.000 a ${'$'}2.500.000",
                    "results": 666
                },
                {
                    "id": "2500000.0-*",
                    "name": "Más de ${'$'}2.500.000",
                    "results": 688
                }
            ]
        },
        {
            "id": "accepts_mercadopago",
            "name": "Filtro por MercadoPago",
            "type": "boolean",
            "values": [
                {
                    "id": "yes",
                    "name": "Con MercadoPago",
                    "results": 1988
                }
            ]
        },
        {
            "id": "installments",
            "name": "Pago",
            "type": "text",
            "values": [
                {
                    "id": "yes",
                    "name": "En cuotas",
                    "results": 1970
                },
                {
                    "id": "no_interest",
                    "name": "Cuotas sin interés",
                    "results": 205
                }
            ]
        },
        {
            "id": "shipping",
            "name": "Envío",
            "type": "text",
            "values": [
                {
                    "id": "mercadoenvios",
                    "name": "Mercado Envíos",
                    "results": 233
                }
            ]
        },
        {
            "id": "power_seller",
            "name": "Filtro por calidad de vendedores",
            "type": "boolean",
            "values": [
                {
                    "id": "yes",
                    "name": "Mejores vendedores",
                    "results": 849
                }
            ]
        },
        {
            "id": "since",
            "name": "Filtro por fecha de comienzo",
            "type": "text",
            "values": [
                {
                    "id": "today",
                    "name": "Publicados hoy",
                    "results": 13
                }
            ]
        },
        {
            "id": "until",
            "name": "Filtro por fecha de finalización",
            "type": "text",
            "values": [
                {
                    "id": "today",
                    "name": "Finalizan hoy",
                    "results": 5
                }
            ]
        },
        {
            "id": "has_video",
            "name": "Filtro por publicaciones con video",
            "type": "boolean",
            "values": [
                {
                    "id": "yes",
                    "name": "Publicaciones con video",
                    "results": 68
                }
            ]
        },
        {
            "id": "has_pictures",
            "name": "Filtro por publicaciones con imágenes",
            "type": "boolean",
            "values": [
                {
                    "id": "yes",
                    "name": "Con fotos",
                    "results": 1988
                }
            ]
        },
        {
            "id": "all_payment_methods_discount",
            "name": "Descuentos para todos los medios de pago",
            "type": "number",
            "values": [
                {
                    "id": "5-100",
                    "name": "Desde 5% OFF",
                    "results": 14
                },
                {
                    "id": "10-100",
                    "name": "Desde 10% OFF",
                    "results": 12
                },
                {
                    "id": "15-100",
                    "name": "Desde 15% OFF",
                    "results": 8
                },
                {
                    "id": "25-100",
                    "name": "Desde 25% OFF",
                    "results": 6
                },
                {
                    "id": "30-100",
                    "name": "Desde 30% OFF",
                    "results": 3
                }
            ]
        },
        {
            "id": "price_campaign_id",
            "name": "Campaña",
            "type": "number",
            "values": [
                {
                    "id": "MCO2298",
                    "name": "MCO2298",
                    "results": 24
                },
                {
                    "id": "P-MCO6244004",
                    "name": "P-MCO6244004",
                    "results": 9
                },
                {
                    "id": "MCO3272",
                    "name": "MCO3272",
                    "results": 1
                }
            ]
        },
        {
            "id": "shipping_cost",
            "name": "Costo de envío",
            "type": "text",
            "values": [
                {
                    "id": "free",
                    "name": "Gratis",
                    "results": 189
                }
            ]
        },
        {
            "id": "BRAND",
            "name": "Marca",
            "type": "STRING",
            "values": [
                {
                    "id": "92625",
                    "name": "Haceb",
                    "results": 184
                },
                {
                    "id": "19835",
                    "name": "Mabe",
                    "results": 161
                },
                {
                    "id": "206",
                    "name": "Samsung",
                    "results": 119
                },
                {
                    "id": "215",
                    "name": "LG",
                    "results": 118
                },
                {
                    "id": "526946",
                    "name": "Danby",
                    "results": 107
                },
                {
                    "id": "12316",
                    "name": "Challenger",
                    "results": 107
                },
                {
                    "id": "4206",
                    "name": "Frigidaire",
                    "results": 103
                },
                {
                    "id": "4004",
                    "name": "Whirlpool",
                    "results": 76
                },
                {
                    "id": "21980",
                    "name": "RCA",
                    "results": 62
                },
                {
                    "id": "2097643",
                    "name": "Galanz",
                    "results": 61
                },
                {
                    "id": "188",
                    "name": "Electrolux",
                    "results": 42
                },
                {
                    "id": "44788",
                    "name": "Koolatron",
                    "results": 29
                },
                {
                    "id": "85315",
                    "name": "Avanti",
                    "results": 25
                },
                {
                    "id": "2149465",
                    "name": "Black+Decker",
                    "results": 25
                },
                {
                    "id": "11352294",
                    "name": "Centrales",
                    "results": 22
                },
                {
                    "id": "81498",
                    "name": "Magic Chef",
                    "results": 21
                },
                {
                    "id": "8893693",
                    "name": "Winia",
                    "results": 20
                },
                {
                    "id": "7702008",
                    "name": "Abba",
                    "results": 17
                },
                {
                    "id": "1218096",
                    "name": "Kenmore",
                    "results": 17
                },
                {
                    "id": "42587",
                    "name": "Midea",
                    "results": 13
                },
                {
                    "id": "9989",
                    "name": "Insignia",
                    "results": 11
                },
                {
                    "id": "11291160",
                    "name": "Walsh",
                    "results": 11
                },
                {
                    "id": "7440228",
                    "name": "General Electric",
                    "results": 10
                },
                {
                    "id": "2889160",
                    "name": "HomeLabs",
                    "results": 10
                },
                {
                    "id": "2505147",
                    "name": "Costway",
                    "results": 10
                },
                {
                    "id": "1117616",
                    "name": "Chefman",
                    "results": 10
                },
                {
                    "id": "30644",
                    "name": "Curtis",
                    "results": 9
                },
                {
                    "id": "2111471",
                    "name": "Commercial Cool",
                    "results": 9
                },
                {
                    "id": "435211",
                    "name": "Nostalgia",
                    "results": 8
                },
                {
                    "id": "3748816",
                    "name": "Smad",
                    "results": 8
                },
                {
                    "id": "2090905",
                    "name": "SPT",
                    "results": 8
                },
                {
                    "id": "19889",
                    "name": "Smeg",
                    "results": 8
                },
                {
                    "id": "443",
                    "name": "KitchenAid",
                    "results": 7
                },
                {
                    "id": "2289306",
                    "name": "NewAir",
                    "results": 7
                },
                {
                    "id": "10252",
                    "name": "Pyle",
                    "results": 7
                },
                {
                    "id": "9908217",
                    "name": "Antarctic Star",
                    "results": 6
                },
                {
                    "id": "8850267",
                    "name": "Kuppet",
                    "results": 6
                },
                {
                    "id": "767792",
                    "name": "GE Appliances",
                    "results": 6
                },
                {
                    "id": "6970929",
                    "name": "Segmart",
                    "results": 6
                },
                {
                    "id": "25063",
                    "name": "Keystone",
                    "results": 6
                },
                {
                    "id": "1180768",
                    "name": "Icasa",
                    "results": 6
                },
                {
                    "id": "1158795",
                    "name": "GE",
                    "results": 6
                },
                {
                    "id": "4946",
                    "name": "Bosch",
                    "results": 5
                },
                {
                    "id": "4040057",
                    "name": "Aicook",
                    "results": 5
                },
                {
                    "id": "3981997",
                    "name": "Coca-Cola",
                    "results": 5
                },
                {
                    "id": "8957985",
                    "name": "Atosa",
                    "results": 4
                },
                {
                    "id": "503834",
                    "name": "Igloo",
                    "results": 4
                },
                {
                    "id": "3280347",
                    "name": "Safeplus",
                    "results": 4
                },
                {
                    "id": "3058376",
                    "name": "Arctic King",
                    "results": 4
                },
                {
                    "id": "900",
                    "name": "Haier",
                    "results": 3
                },
                {
                    "id": "8588117",
                    "name": "Moosoo",
                    "results": 3
                },
                {
                    "id": "7726885",
                    "name": "Indurama",
                    "results": 3
                },
                {
                    "id": "42690",
                    "name": "Imbera",
                    "results": 3
                },
                {
                    "id": "2840500",
                    "name": "Corona",
                    "results": 3
                },
                {
                    "id": "979934",
                    "name": "EdgeStar",
                    "results": 2
                },
                {
                    "id": "6882848",
                    "name": "Lorell",
                    "results": 2
                },
                {
                    "id": "6845967",
                    "name": "Iker",
                    "results": 2
                },
                {
                    "id": "5609057",
                    "name": "Smeta",
                    "results": 2
                },
                {
                    "id": "4910813",
                    "name": "Topzone",
                    "results": 2
                },
                {
                    "id": "4327518",
                    "name": "XtremPro",
                    "results": 2
                },
                {
                    "id": "3901801",
                    "name": "Kalamera",
                    "results": 2
                },
                {
                    "id": "2571139",
                    "name": "Impecca",
                    "results": 2
                },
                {
                    "id": "2508439",
                    "name": "Uline",
                    "results": 2
                },
                {
                    "id": "2222606",
                    "name": "Whynter",
                    "results": 2
                },
                {
                    "id": "2221474",
                    "name": "TaoTronics",
                    "results": 2
                },
                {
                    "id": "2111486",
                    "name": "Sunpentown",
                    "results": 2
                },
                {
                    "id": "12197076",
                    "name": "Genérico",
                    "results": 2
                },
                {
                    "id": "11883420",
                    "name": "Coca Cola",
                    "results": 2
                },
                {
                    "id": "11413285",
                    "name": "Perlick",
                    "results": 2
                },
                {
                    "id": "10331273",
                    "name": "Generic",
                    "results": 2
                },
                {
                    "id": "9946069",
                    "name": "Indufrial",
                    "results": 1
                },
                {
                    "id": "9905537",
                    "name": "Nasa de Colombia",
                    "results": 1
                },
                {
                    "id": "9880359",
                    "name": "Norcold",
                    "results": 1
                },
                {
                    "id": "973751",
                    "name": "Tornado",
                    "results": 1
                },
                {
                    "id": "973748",
                    "name": "Giantex",
                    "results": 1
                },
                {
                    "id": "9251520",
                    "name": "Sankey",
                    "results": 1
                },
                {
                    "id": "9013436",
                    "name": "Exceline",
                    "results": 1
                },
                {
                    "id": "8",
                    "name": "Panasonic",
                    "results": 1
                },
                {
                    "id": "779",
                    "name": "Kelvinator",
                    "results": 1
                },
                {
                    "id": "7743745",
                    "name": "Panavox",
                    "results": 1
                },
                {
                    "id": "7618203",
                    "name": "Nórdico",
                    "results": 1
                },
                {
                    "id": "7371632",
                    "name": "Furrion",
                    "results": 1
                },
                {
                    "id": "7067744",
                    "name": "Antigua",
                    "results": 1
                },
                {
                    "id": "6790032",
                    "name": "Main Event",
                    "results": 1
                },
                {
                    "id": "5645054",
                    "name": "Smoko",
                    "results": 1
                },
                {
                    "id": "5070759",
                    "name": "Americano",
                    "results": 1
                },
                {
                    "id": "42768",
                    "name": "Criotec",
                    "results": 1
                },
                {
                    "id": "4208",
                    "name": "Daewoo",
                    "results": 1
                },
                {
                    "id": "4003728",
                    "name": "Thor Kitchen",
                    "results": 1
                },
                {
                    "id": "3994",
                    "name": "Marshall",
                    "results": 1
                },
                {
                    "id": "3",
                    "name": "Philips",
                    "results": 1
                },
                {
                    "id": "2946558",
                    "name": "Mili",
                    "results": 1
                },
                {
                    "id": "2840499",
                    "name": "Budweiser",
                    "results": 1
                },
                {
                    "id": "27413",
                    "name": "Thomson",
                    "results": 1
                },
                {
                    "id": "2382246",
                    "name": "Smartlife",
                    "results": 1
                },
                {
                    "id": "2109534",
                    "name": "Best Choice Products",
                    "results": 1
                },
                {
                    "id": "19879",
                    "name": "Peabody",
                    "results": 1
                },
                {
                    "id": "166412",
                    "name": "Wonder",
                    "results": 1
                },
                {
                    "id": "10127865",
                    "name": "Zimtown",
                    "results": 1
                }
            ]
        },
        {
            "id": "DEFROST_TYPE",
            "name": "Tipo de deshielo",
            "type": "STRING",
            "values": [
                {
                    "id": "4603562",
                    "name": "No frost",
                    "results": 689
                },
                {
                    "id": "298327",
                    "name": "Manual",
                    "results": 107
                },
                {
                    "id": "298328",
                    "name": "Semiautomático",
                    "results": 66
                },
                {
                    "id": "298329",
                    "name": "Auto defrost",
                    "results": 41
                },
                {
                    "id": "2496258",
                    "name": "Frost free",
                    "results": 39
                },
                {
                    "id": "317031",
                    "name": "Frío directo",
                    "results": 17
                },
                {
                    "id": "299645",
                    "name": "Cycle defrost",
                    "results": 8
                },
                {
                    "id": "317032",
                    "name": "Neo frost",
                    "results": 7
                },
                {
                    "id": "9272337",
                    "name": "Adaptive defrost",
                    "results": 5
                },
                {
                    "id": "9849952",
                    "name": "Automático",
                    "results": 1
                }
            ]
        },
        {
            "id": "ENERGY_EFFICIENCY",
            "name": "Eficiencia energética",
            "type": "STRING",
            "values": [
                {
                    "id": "98473",
                    "name": "A",
                    "results": 349
                },
                {
                    "id": "103827",
                    "name": "B",
                    "results": 199
                },
                {
                    "id": "2307502",
                    "name": "A+",
                    "results": 134
                },
                {
                    "id": "417554",
                    "name": "D",
                    "results": 16
                },
                {
                    "id": "417553",
                    "name": "C",
                    "results": 10
                },
                {
                    "id": "2307503",
                    "name": "A++",
                    "results": 8
                },
                {
                    "id": "98474",
                    "name": "AA",
                    "results": 1
                }
            ]
        },
        {
            "id": "FREEZER_LOCATION",
            "name": "Ubicación del freezer",
            "type": "STRING",
            "values": [
                {
                    "id": "79469",
                    "name": "Superior",
                    "results": 553
                },
                {
                    "id": "79470",
                    "name": "Inferior",
                    "results": 127
                },
                {
                    "id": "82355",
                    "name": "Side by side",
                    "results": 99
                }
            ]
        },
        {
            "id": "ITEM_CONDITION",
            "name": "Condición",
            "type": "STRING",
            "values": [
                {
                    "id": "2230284",
                    "name": "Nuevo",
                    "results": 1379
                },
                {
                    "id": "2230581",
                    "name": "Usado",
                    "results": 600
                },
                {
                    "id": "2230582",
                    "name": "Reacondicionado",
                    "results": 3
                }
            ]
        },
        {
            "id": "SHIPPING_ORIGIN",
            "name": "Tipo de compra",
            "type": "STRING",
            "values": [
                {
                    "id": "10215068",
                    "name": "Local",
                    "results": 1988
                }
            ]
        },
        {
            "id": "TOTAL_CAPACITY",
            "name": "Capacidad total",
            "type": "range",
            "values": [
                {
                    "id": "(*-150L]",
                    "name": "150 L o menos",
                    "results": 254
                },
                {
                    "id": "[150L-300L]",
                    "name": "150 a 300 L",
                    "results": 328
                },
                {
                    "id": "[300L-450L]",
                    "name": "300 a 450 L",
                    "results": 290
                },
                {
                    "id": "[450L-*)",
                    "name": "450 L o más",
                    "results": 243
                }
            ]
        },
        {
            "id": "WIDTH",
            "name": "Ancho",
            "type": "range",
            "values": [
                {
                    "id": "(*-60.96cm)",
                    "name": "Menos de 60,96 cm",
                    "results": 553
                },
                {
                    "id": "[60.96cm-*)",
                    "name": "60,96 cm o más",
                    "results": 577
                }
            ]
        },
        {
            "id": "WITH_FREEZER",
            "name": "Freezer",
            "type": "boolean",
            "values": [
                {
                    "id": "242085",
                    "name": "Con freezer",
                    "results": 827
                },
                {
                    "id": "242084",
                    "name": "Sin freezer",
                    "results": 225
                }
            ]
        },
        {
            "id": "WITH_INVERTER_TECHNOLOGY",
            "name": "Otras características",
            "type": "boolean",
            "values": [
                {
                    "id": "242085",
                    "name": "Con tecnología inverter",
                    "results": 459
                }
            ]
        }
    ]
}""")
        val search : Search = Gson().fromJson(jsonObject.toString(), Search::class.java)
        val response = success(search)
        coEvery { productsRemoteData.getAllProducts(any()) } returns  response

        //When
        productsRepository.getProductsByQuery(ArgumentMatchers.any())

        //Then
        assert(productsRepository.searchByQuery.value == search)
    }


    @Test
    fun `when is called get description by product id`() = runBlocking {
        //Given
        val jsonObject = JSONObject("""{
    "text": "",
    "plain_text": "Con presencia a nivel mundial, Mabe crea soluciones con tecnología vanguardista para tu hogar. Ofrece productos de refrigeración con diseño moderno para una mejor organización y conservación de los alimentos.\n\nComodidad para tu hogar\nSu sistema no frost evita la formación de hielo y te permitirá conservar el sabor y las propiedades nutritivas de los productos.\n\nFrescura en tus alimentos\nCada vez que abres la puerta se cuela aire caliente; por eso, al tener control de temperatura podrás regular los grados para que tus productos se mantengan siempre frescos. \n\nEficiencia energética y utilidad\nGracias a su eficiencia energética B, vas a ahorrar en la economía de tu hogar y aprovechar al máximo su rendimiento, ya que cuenta con un 35% de ahorro de consumo. Además, con su dispensador de agua podrás refrescarte rápidamente sin tener que abrirla. \n\nPracticidad interior\nLa disposición de 2 estantes te proporcionará un gran ahorro de espacio y fácil localización de tus productos. Gracias a su resistente material no tendrás que preocuparte por el peso que deposites en ellos y organizarás a tu gusto cada rincón para optimizar su uso. Cuenta con",
    "last_updated": "2022-06-06T13:07:17.912Z",
    "date_created": "2022-06-06T13:07:17.912Z",
    "snapshot": {
        "url": "http://descriptions.mlstatic.com/D-MCO903901929.jpg?hash=8520c3b8559cb08aa7e782b8f5334ffe_0x0",
        "width": 0,
        "height": 0,
        "status": ""
    }
}""")
        val descriptionByItem : Description = Gson().fromJson(jsonObject.toString(), Description::class.java)
        val response = success(descriptionByItem)
        coEvery { productsRemoteData.getDescriptionByProductId(any()) } returns response

        //When
        productsRepository.getProductDescriptionById(ArgumentMatchers.any())
        //Then

        assert(productsRepository.descriptionById.value == descriptionByItem)
    }

    @Test
    fun `when is called get item by product id`() = runBlocking {

        //Given
        val jsonObject = JSONObject("""{
    "id": "MLA739815392",
    "site_id": "MLA",
    "title": "Asiento Velo Race Competición Mtb Y Ruta - Ciclos",
    "subtitle": null,
    "seller_id": 33762651,
    "category_id": "MLA78904",
    "official_store_id": null,
    "price": 5980,
    "base_price": 5980,
    "original_price": null,
    "currency_id": "ARS",
    "initial_quantity": 107,
    "available_quantity": 1,
    "sold_quantity": 100,
    "sale_terms": [
        {
            "id": "WARRANTY_TYPE",
            "name": "Tipo de garantía",
            "value_id": "2230280",
            "value_name": "Garantía del vendedor",
            "value_struct": null,
            "values": [
                {
                    "id": "2230280",
                    "name": "Garantía del vendedor",
                    "struct": null
                }
            ]
        },
        {
            "id": "WARRANTY_TIME",
            "name": "Tiempo de garantía",
            "value_id": null,
            "value_name": "3 meses",
            "value_struct": {
                "number": 3,
                "unit": "meses"
            },
            "values": [
                {
                    "id": null,
                    "name": "3 meses",
                    "struct": {
                        "number": 3,
                        "unit": "meses"
                    }
                }
            ]
        }
    ],
    "buying_mode": "buy_it_now",
    "listing_type_id": "gold_special",
    "start_time": "2018-07-28T15:48:20.000Z",
    "stop_time": "2038-07-23T04:00:00.000Z",
    "condition": "new",
    "permalink": "https://articulo.mercadolibre.com.ar/MLA-739815392-asiento-velo-race-competicion-mtb-y-ruta-ciclos-_JM",
    "thumbnail_id": "690721-MLA31130076623_062019",
    "thumbnail": "http://http2.mlstatic.com/D_690721-MLA31130076623_062019-I.jpg",
    "secure_thumbnail": "https://http2.mlstatic.com/D_690721-MLA31130076623_062019-I.jpg",
    "pictures": [
        {
            "id": "690721-MLA31130076623_062019",
            "url": "http://http2.mlstatic.com/D_690721-MLA31130076623_062019-O.jpg",
            "secure_url": "https://http2.mlstatic.com/D_690721-MLA31130076623_062019-O.jpg",
            "size": "500x500",
            "max_size": "1200x1200",
            "quality": ""
        },
        {
            "id": "921492-MLA31119365003_062019",
            "url": "http://http2.mlstatic.com/D_921492-MLA31119365003_062019-O.jpg",
            "secure_url": "https://http2.mlstatic.com/D_921492-MLA31119365003_062019-O.jpg",
            "size": "500x262",
            "max_size": "800x420",
            "quality": ""
        },
        {
            "id": "618107-MLA31119364020_062019",
            "url": "http://http2.mlstatic.com/D_618107-MLA31119364020_062019-O.jpg",
            "secure_url": "https://http2.mlstatic.com/D_618107-MLA31119364020_062019-O.jpg",
            "size": "500x246",
            "max_size": "879x433",
            "quality": ""
        }
    ],
    "video_id": null,
    "descriptions": [],
    "accepts_mercadopago": true,
    "non_mercado_pago_payment_methods": [],
    "shipping": {
        "mode": "me2",
        "methods": [],
        "tags": [
            "self_service_in",
            "mandatory_free_shipping"
        ],
        "dimensions": null,
        "local_pick_up": true,
        "free_shipping": true,
        "logistic_type": "cross_docking",
        "store_pick_up": false
    },
    "international_delivery_mode": "none",
    "seller_address": {
        "city": {
            "id": "TUxBQlBBTDI1MTVa",
            "name": "Palermo"
        },
        "state": {
            "id": "AR-C",
            "name": "Capital Federal"
        },
        "country": {
            "id": "AR",
            "name": "Argentina"
        },
        "search_location": {
            "neighborhood": {
                "id": "TUxBQlBBTDI1MTVa",
                "name": "Palermo"
            },
            "city": {
                "id": "TUxBQ0NBUGZlZG1sYQ",
                "name": "Capital Federal"
            },
            "state": {
                "id": "TUxBUENBUGw3M2E1",
                "name": "Capital Federal"
            }
        },
        "id": 197122826
    },
    "seller_contact": null,
    "location": {},
    "coverage_areas": [],
    "attributes": [
        {
            "id": "BICYCLE_SEAT_TYPE",
            "name": "Tipo de asiento",
            "value_id": "3973048",
            "value_name": "Mountain bike",
            "value_struct": null,
            "values": [
                {
                    "id": "3973048",
                    "name": "Mountain bike",
                    "struct": null
                }
            ],
            "attribute_group_id": "OTHERS",
            "attribute_group_name": "Otros"
        },
        {
            "id": "BRAND",
            "name": "Marca",
            "value_id": "3973025",
            "value_name": "Velo",
            "value_struct": null,
            "values": [
                {
                    "id": "3973025",
                    "name": "Velo",
                    "struct": null
                }
            ],
            "attribute_group_id": "OTHERS",
            "attribute_group_name": "Otros"
        },
        {
            "id": "GENDER",
            "name": "Género",
            "value_id": "110461",
            "value_name": "Sin género",
            "value_struct": null,
            "values": [
                {
                    "id": "110461",
                    "name": "Sin género",
                    "struct": null
                }
            ],
            "attribute_group_id": "OTHERS",
            "attribute_group_name": "Otros"
        },
        {
            "id": "GTIN",
            "name": "Código universal de producto",
            "value_id": "-1",
            "value_name": null,
            "value_struct": null,
            "values": [
                {
                    "id": "-1",
                    "name": null,
                    "struct": null
                }
            ],
            "attribute_group_id": "OTHERS",
            "attribute_group_name": "Otros"
        },
        {
            "id": "IS_ANTIPROSTATIC",
            "name": "Es antiprostático",
            "value_id": "242085",
            "value_name": "Sí",
            "value_struct": null,
            "values": [
                {
                    "id": "242085",
                    "name": "Sí",
                    "struct": null
                }
            ],
            "attribute_group_id": "OTHERS",
            "attribute_group_name": "Otros"
        },
        {
            "id": "ITEM_CONDITION",
            "name": "Condición del ítem",
            "value_id": "2230284",
            "value_name": "Nuevo",
            "value_struct": null,
            "values": [
                {
                    "id": "2230284",
                    "name": "Nuevo",
                    "struct": null
                }
            ],
            "attribute_group_id": "OTHERS",
            "attribute_group_name": "Otros"
        },
        {
            "id": "MATERIAL",
            "name": "Material",
            "value_id": "-1",
            "value_name": null,
            "value_struct": null,
            "values": [
                {
                    "id": "-1",
                    "name": null,
                    "struct": null
                }
            ],
            "attribute_group_id": "OTHERS",
            "attribute_group_name": "Otros"
        },
        {
            "id": "MODEL",
            "name": "Modelo",
            "value_id": "5479514",
            "value_name": "VL-1635",
            "value_struct": null,
            "values": [
                {
                    "id": "5479514",
                    "name": "VL-1635",
                    "struct": null
                }
            ],
            "attribute_group_id": "OTHERS",
            "attribute_group_name": "Otros"
        },
        {
            "id": "SELLER_SKU",
            "name": "SKU",
            "value_id": null,
            "value_name": "VL-1635",
            "value_struct": null,
            "values": [
                {
                    "id": null,
                    "name": "VL-1635",
                    "struct": null
                }
            ],
            "attribute_group_id": "OTHERS",
            "attribute_group_name": "Otros"
        }
    ],
    "warnings": [],
    "listing_source": "",
    "variations": [],
    "status": "active",
    "sub_status": [],
    "tags": [
        "good_quality_picture",
        "good_quality_thumbnail",
        "loyalty_discount_eligible",
        "brand_verified",
        "immediate_payment",
        "cart_eligible"
    ],
    "warranty": "Garantía del vendedor: 3 meses",
    "catalog_product_id": "MLA12995236",
    "domain_id": "MLA-BICYCLE_SEATS",
    "parent_item_id": null,
    "differential_pricing": null,
    "deal_ids": [],
    "automatic_relist": false,
    "date_created": "2018-07-28T15:48:20.000Z",
    "last_updated": "2022-06-29T15:01:56.000Z",
    "health": 0.88,
    "catalog_listing": false,
    "channels": [
        "marketplace",
        "mshops"
    ]
}""")
        val item : Item = Gson().fromJson(jsonObject.toString(), Item::class.java)
        val response = success(item)
        coEvery { productsRemoteData.getItemByProductId(any()) } returns response

        //When
        productsRepository.getItemByProductId(ArgumentMatchers.any())

        //Then
        assert(productsRepository.item.value == item)
    }


}