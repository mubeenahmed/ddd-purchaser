
class ElasticSearchConfig:
    HOST = 'localhost'
    PORT = 9200

class DevelopmentConfig:
    DEBUG = True
    ENV = 'development'
    APP = 'product_api.py'

class ProductionConfig:
    DEBUG = False
    APP = 'product_api.py'