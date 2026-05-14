import sys
import json
import importlib.util

def exec(script, method, args):
    try:
        spec = importlib.util.spec_from_loader("spider", loader=None)
        module = importlib.util.module_from_spec(spec)
        exec(script, module.__dict__)
        func = getattr(module, method, None)
        if func:
            return json.dumps(func(*args))
    except Exception as e:
        pass
    return json.dumps({})